package baekjoonAG;
import java.util.Scanner;

public class baek10819 {
//fgfgfgfgf
	static int max=0;
	static boolean check =false;
	static void swapArray(int ar[],int a, int b) {
		int k=0;		
		for(int i=a;i<=a+(b-a)/2;i++) {
			int temp = ar[i];
			ar[i] = ar[b-k];
			ar[b-k] = temp;
			k++;
		}
	}
	
	static int CalculateMax(int []arr) {
		int value = 0;
		for(int i=0;i<arr.length-1;i++) {
			int sum1 = arr[i] - arr[i+1];
			if(sum1 < 0) sum1 = -sum1;
			value += sum1;
		}
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int fakearr[] = new int[n];
		int valuearr[] = new int[n];
		
		for(int t=0;t<n;t++) arr[t] = sc.nextInt();
		for( int u=0;u<n;u++) fakearr[u]=u+1;

		int count=0;
		
		while(true) {
			
		int i=0;
		int sum=0;
		check = false;
		for(int k=n-1;k>=1;k--) if(fakearr[k-1] < fakearr[k]) { i = k; check=true; break;}
		if(check == true) {
			for(int j=n-1;j>i-1;j--) {
				if(fakearr[i-1] <= fakearr[j]) {
					int temp = fakearr[j];
					fakearr[j] = fakearr[i-1];
					fakearr[i-1] = temp;

					swapArray(fakearr,i, n-1);
					
					for(int l=0;l<n;l++) {
						if(fakearr[l] == 1) valuearr[l] = arr[0];
						if(fakearr[l] == 2) valuearr[l] = arr[1];
						if(fakearr[l] == 3) valuearr[l] = arr[2];
						if(fakearr[l] == 4) valuearr[l] = arr[3];
						if(fakearr[l] == 5) valuearr[l] = arr[4];
						if(fakearr[l] == 6) valuearr[l] = arr[5];
						if(fakearr[l] == 7) valuearr[l] = arr[6];
						if(fakearr[l] == 8) valuearr[l] = arr[7];									
					}
					sum = CalculateMax(valuearr);
					if(max < sum) max = sum;
					sum=0;
					break;
				}
			}

		}
		else {

			System.out.println(max);
			break;
		}
		
		}
		
	}

}
