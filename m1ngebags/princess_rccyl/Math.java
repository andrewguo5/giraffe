public class Math {

    public static int add(int a, int b){
	return a + b;
    }

    public static int sub(int a, int b){
	return a - b;
    }

    public static int mult(int a, int b){
	int ans = 0;
	while (b>0){
	    ans = add(ans,a);
	    b--;
	}
	return ans;
    }     

    public static int divi(int a, int b){
	int ans = 0;
	while (a>0){
	    ans++;
	    a= sub(a,b);
	}
	return ans;

    }
    public static int exp(int a, int b){
	if (b==0){
	    return 1;
	}
	else { 
	    int ans = a;
	    while (b>1){
		ans = mult(ans,a);
		b--;
	    }
	    return ans;
	}
    }
  
    public static void main (String[]args){
	System.out.println(add(4,5));
	System.out.println(add(0,5));
	System.out.println(add(4,0));
	System.out.println(add(5,-4));
	System.out.println(sub(1,4));
	System.out.println(sub(9,-4));
	System.out.println(sub(9,4));
	System.out.println(mult(4,5));
	System.out.println(mult(0,5));
	System.out.println(mult(1,9));
	System.out.println(divi(20,5));
	System.out.println(divi(20,6));
	System.out.println(divi(31,1));
	System.out.println(divi(31,0));
	System.out.println(exp(2,0));
	System.out.println(exp(3,1));
	System.out.println(exp(2,5));
	System.out.println(exp(2,-5));
    }

}
