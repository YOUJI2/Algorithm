package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek15649 {
	
		static boolean check[] = new boolean[10];
		static int a[];
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = in.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		a = new int[10];
		
		NandM(0,n,m);
		bw.close();
		
	}
	
	static void NandM(int index, int n, int m) {
		
		if(index == m) {
			for(int i=0;i<m;i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) { //n정수 각각 입력
			if(check[i] == true) continue;
			else {
			check[i] = true;
			a[index] = i;
			NandM(index+1,n,m);
			check[i] = false;
			}
		}
		
		
		
	}
	

}
