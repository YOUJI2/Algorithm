package baekjoonAG;

import java.util.ArrayList;
import java.util.Scanner;

public class baek6603 {

	static ArrayList<Integer> lotto = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		while(true) {
			
			int n = sc.nextInt();
			if(n == 0) break;
			int arr[] = new int[n];
			for(int i=0 ;i<n;i++) arr[i] = sc.nextInt();
			solveLotto(arr,0,0);			
			System.out.println();
		}
	}

	static void solveLotto(int arr[], int index, int cnt) {
		if(cnt == 6) {
			for(int element : lotto) {
				System.out.print(element+" ");
			}
			System.out.println();
			return;
		}
		if(index == arr.length) return;
		lotto.add(arr[index]);
		solveLotto(arr,index+1,cnt+1);
		lotto.remove(lotto.size()-1);
		solveLotto(arr,index+1,cnt);
		
	}
	
	
}
