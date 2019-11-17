package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class baek11723 {
//	static Strin checkstr="";
	static int s = 0;
	static void add(int x) {
		s = s | ( 1 << x);
	}
	static void remove(int x) {
		s = s & ~(1<<x);
	}

	static void toggle(int x) {
		s =( s^(1<<x));
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int m = Integer.parseInt(in.readLine());
		String[] str;
		
		
//		int m = sc.nextInt();
//		sc.nextLine();

		for(int i=0;i<m;i++) {
//			String[] str = sc.nextLine().split(" ");
			str = in.readLine().split(" ");
			String req = str[0];
			if(req.equals("all")) {
				s = ((1<<20)-1);
			}else if(req.equals("empty")) {
				s = 0;
			}else {
				int x = Integer.parseInt(str[1]);
				if(req.equals("add")) {
					add(x-1);
				}
				else if(req.equals("remove")) {
					remove(x-1);
				}
				else if(req.equals("check")) {
//					check(x-1);
					if((s & (1<<(x-1))) != 0) {
						bw.write(1+"\n");
//						checkstr += "1"+'\n';
//						System.out.println("1");
					}else {
						bw.write(0+"\n");
//						checkstr += "0"+'\n';
//						System.out.println("0");
					}


				
				
				}
				else if(req.equals("toggle")) {
					toggle(x-1);
				}
			}
		}
//		System.out.println(checkstr);
		bw.close();
		
	}

}
