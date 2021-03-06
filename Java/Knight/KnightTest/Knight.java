import java.util.*;

public class Knight {

    private int[][] board;
    private int startX, startY;
    private int maxX, maxY;
    private int moveCtr = 0;
    private boolean finished = false;
    private ArrayList <String> stepList;
    
    public Knight(int x) {
	startX = 0;
	startY = 0;
	maxX = x-1;
	maxY = x-1;
	board = new int[x][x];
	stepList = new ArrayList<String>();
    }

    public Knight(int x, int y) {
	startX = 0;
	startY = 0;
	maxX = x - 1;
	maxY = y - 1;
	board = new int[x][y];
    }
    
    public Knight(int x, int y, int sx, int sy) {
	startX = sx;
	startY = sy;
	maxX = x - 1;
	maxY = y - 1;
	board = new int[x][y];
    }

    //taken from Mazesolver
    public String clear(){
	return  "[2J";
    }   
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    } 

    public String toString() {
	//	if (board[startX][startY] == 0) {
	//	    return "There are no solutions";
	//}
	//	else {
	    String retStr = "";
	    for (int x = 0; x <= maxX; x++) {
		for (int y = 0; y <= maxY; y++) {
		    String val = "__";
		    if (board[x][y] != 0 ) {
			if (board[x][y] > 9) {
			    val = "" + board[x][y];
			}
			else {
			    val = "0" + board[x][y];
			}
		    }
		    if (x%2 == 0 && y%2 == 0 ) retStr += "." + val + ".";
		    else if (x%2 == 1 && y%2 == 1 ) retStr += "." + val + ".";
		    else retStr += " " + val + " ";
		}
		retStr += "\n";
	    }
	    return retStr;
	    //	}
    }
    /*
    public void solveClosed(int x, int y) {
	moveCtr ++;
	startX = x;
	startY = y;
	if ( (moveCtr == (maxX + 1) * (maxY + 1) + 1)  && (board[x][y] == 1) ) {
	    finished = true;
	}	   
	else if (board[x][y] == 0 && !finished) {
	    board[x][y] = moveCtr;
	}
	//wait(20);
	//turtles are debug
	//System.out.println(clear() );
	//System.out.println(this); 
	
	if (!finished && y < maxY - 1 && x > 0 ) { 
	    //System.out.println("turtles1");
	    if (board[x-1][y+2] == 0)
		solveClosed(x-1, y+2);
	}
	if (!finished && y < maxY - 1 && x < maxX ) { 
	    //System.out.println("turtles2");

	    if (board[x+1][y+2] == 0)
		solveClosed(x+1, y+2);
	}
	if (!finished && y < maxX && x < maxX - 1 ) { 
	    // System.out.println("turtles3");
	    if (board[x+2][y+1] == 0)
		solveClosed(x+2, y+1);
	}
	if (!finished && y > 0 && x < maxX - 1 ) {
	    //System.out.println("turtles4");
	    if (board[x+2][y-1] == 0)
		solveClosed(x+2, y-1);
	} 
	if (!finished && y > 1 && x > 0 ) { 
	    //System.out.println("turtles5");
	    if (board[x-1][y-2] == 0)
		solveClosed(x-1, y-2);
	}	 
	if (!finished && y > 1 && x < maxX ) { 
	    //System.out.println("turtles6");
	    if (board[x+1][y-2] == 0)
		solveClosed(x+1, y-2);
	}
	if (!finished && y < maxY && x > 1 ) { 
	    //System.out.println("turtles7");
	    if (board[x-2][y+1] == 0)
		solveClosed(x-2, y+1);
	}
	if (!finished && y > 0 && x > 1 ) { 
	    //System.out.println("turtles8");
	    if (board[x-2][y-1] == 0)
		solveClosed(x-2, y-1);
	}
	if (!finished) {
	    board[x][y] = 0;
	    moveCtr--;
	}
	
    }*/


    public void solve(int x, int y) {
	//System.out.println(this);
	moveCtr++;
	if ( moveCtr == (maxX + 1) * (maxY + 1) + 1)  {
	    finished = true;
	    //System.out.println("turtles");
	}
	if (!finished) {
	    if (! (x < 0 || x > maxX || y < 0 || y > maxY) &&
		board[x][y] == 0 ) 
		{
		    board[x][y] = moveCtr;
		    stepList.add( "(" + x + " ," + y + ")" );
		    if (!finished)solve(x + 2, y + 1); 
		    if (!finished)solve(x + 2, y - 1);
		    if (!finished)solve(x - 2, y + 1);
		    if (!finished)solve(x + 2, y - 1);
		    if (!finished)solve(x + 1, y + 2);
		    if (!finished)solve(x - 1, y + 2);
		    if (!finished)solve(x + 1, y - 2);
		    if (!finished)solve(x - 1, y - 2);
		    if (!finished){ 
			board[x][y] = 0;
			stepList.remove(moveCtr - 1);
			moveCtr --; 
		    }
		}
	    else 
		moveCtr --; 
	}
	/*
	if (finished) {

	    System.out.println(moveCtr);
	    System.out.println(stepList.get(0) );
	    for (int n = moveCtr - 2; n > 0; n--) {
		//System.out.print("Step " + n + ": ");
		//	System.out.println(stepList.get(n) );
	    }
	}*/

    } 

    public void solve() {
	solve(0, 0);
	//	System.out.println(moveCtr); 
	for (int n = moveCtr - 1; n > 0; n--) {
	    System.out.print("Step " + n + ": ");
	    System.out.println(stepList.get(n-1) );
	}
	System.out.println();
    }

    //  public static void main (String[] args) {
	//	Knight board1 = new Knight(3,3);
	//System.out.println(board1);
	//	board1.solve(2, 2);
	//	System.out.println(board1);
	//System.out.println( clear() );	
    // }
					 

}

