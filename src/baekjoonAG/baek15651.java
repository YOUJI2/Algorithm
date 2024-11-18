package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek15651 {
		static BufferedReader in;
		static BufferedWriter bw;
		static boolean check[] = new boolean[10];
		static int a[];
	
	public static void main(String[] args) throws IOException {

		
		in = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = in.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		a = new int[10];
		
		NandM(0,n,m);
		bw.close();
		
	}
	
	static void NandM(int index, int n, int m) throws IOException {
		
		if(index == m) {
			for(int i=0;i<m;i++) {
//				System.out.print(a[i]+" ");
				bw.write(a[i]+" ");
			}
			bw.write("\n");
			return;
		}
		for(int i=1;i<=n;i++) { //n정수 각각 입력
	
		
			check[i] = true;
			a[index] = i;
			NandM(index+1,n,m);
			check[i] = false;
			
		}
		
		
		
	}
	

}
