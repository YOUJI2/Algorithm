package baekjoonAG;

import java.util.Scanner;

public class baek1107 {
	static boolean broken[] = new boolean[10];
	static int possible(int c) {
		if(c == 0 ) {
			if(broken[0] == true) return 0;
			else return 1;
		}
		int len=0;
		while(c > 0) {
			if(broken[c%10] == true) return 0;
			len += 1;
			c /= 10;
		}
		return len;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		for(int i=0;i<t;i++) {
			int k = sc.nextInt();
			broken[k] = true;
		}
		int ans = n-100;
		if(ans < 0) ans = -ans;
		for(int i=0;i<=1000000;i++) {
			int c = i;
			int len = possible(c);
			if(len>0) {
				int press = c-n;
				if(press < 0) press = -press;
				if(ans > len + press) ans = len+press;
			}
		}
		System.out.println(ans);
	}

}
