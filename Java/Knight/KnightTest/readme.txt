Knights Tour
Andrew Guo

The knight's tour algorithm is very similar to the algorithm used to solve the 
maze, with eight possible moves instead of four. 

A double array of integers is used as a chessboard, and an instance variable
moveCtr keeps track of the number of moves made whenever the solve method tries
to find a solution. An instance variable ArrayList keeps track of the 
coordinates of each move, in order. 

The board does not have a border or buffer around the edges, to prevent out of 
bounds exceptions. Instead, in the recursive solve(int x, int y) method, the 
recursive calls are only made if they pass booleans that ask whether the 
recursive call runs out of bounds or not. Eight recursive calls are made,
each with a corresponding if statement. The method will first check the two
knight moves to the right, then the two knight moves to the left, then the two 
to the up and down. 

The base case for the recursion is when the instance variable moveCtr is one
greater than the number of squares on the board.

An arrayList of Strings records the coordinates of each move made, removing
the last entry if it does not provide a solution. In the body of the solve()
method, the one that calls the recursive solve(int x, int y) method, a for
loop is used to print all of the coordinates of the moves in order from the
ArrayList.
