package baekjoonAG;

import java.util.Scanner;

public class baek6064 {
	static int result[];
	static int count,x,y,m,n;
	static int finalcount=0;
	
	static void go(int i, int j) {
		
		if(count % m == x && count % n == y ) {
			result[finalcount++] = count;
			return;
		}
//		else if( ) {
//		
//}
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		result = new int[t+1];
		
		for(int i=0;i<t;i++) {
			count=0;
			m = sc.nextInt();
			n = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			
			
		}
	}

}
