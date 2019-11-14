package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baek15652 {

	static boolean check[] = new boolean[10];
	static int a[];

public static void main(String[] args) throws IOException {

	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	String str[] = in.readLine().split(" ");
	int n = Integer.parseInt(str[0]);
	int m = Integer.parseInt(str[1]);
	
	a = new int[10];
	
	NandM(0,n,m,1);
	
}

static void NandM(int index, int n, int m, int start) {
	
	if(index == m) {
		for(int i=0;i<m;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		return;
	}
	for(int i=start;i<=n;i++) { //n정수 각각 입력
	
		
		check[i] = true;
		a[index] = i;
		NandM(index+1,n,m,i);
		check[i] = false;
		
	}
	
	
	
}

}
