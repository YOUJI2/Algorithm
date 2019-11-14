package baekjoonAG;

import java.util.Arrays;
import java.util.Scanner;

public class baek1759 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //길이
		int m = sc.nextInt(); //문자 갯수 
		sc.nextLine();
		String alpha = new String();
		alpha = sc.nextLine();

		int k=0;
		char[] c = new char[m];
		for(int i=0;i<alpha.length();i++) {
			if(alpha.charAt(i) != ' ') {
				c[k] = alpha.charAt(i);
				k++;
			}
						
		}
			

		Arrays.sort(c);

		Password(n,c,"",0);
		
	}

	static void Password(int n, char ar[], String password, int index) {
		if(password.length() == n) {
			boolean checkPw = Check(password);
			if(checkPw == true) {
				System.out.println(password);
			}
			return;
		}
		if(index == ar.length) return;
		Password(n,ar,password+ar[index],index+1);
		Password(n,ar,password,index+1);
	}
	
	static boolean Check(String password) {
		
		int a=0; //모음
		int b=0; //자음
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i) == 'a' || password.charAt(i) == 'e' || password.charAt(i) == 'i' || password.charAt(i) == 'o' || password.charAt(i) == 'u') {
				a++;
			}else {
				b++;
			}
		}
		if(a>=1 && b>=2) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
