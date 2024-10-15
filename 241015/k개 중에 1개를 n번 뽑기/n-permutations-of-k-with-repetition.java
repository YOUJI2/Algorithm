import java.util.*;
public class Main {
    public static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        list = new ArrayList<>();

        chooseNum(k, n);
    }

    public static void chooseNum(int k, int n) {
        
        if(n == 0) {            
            printList();
            return;
        }

        for(int i=1;i<=k;i++) {
            list.add(i);
            chooseNum(k, n-1);
            list.remove(list.size() - 1);
        }
    }

    public static void printList() {
        for(int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}