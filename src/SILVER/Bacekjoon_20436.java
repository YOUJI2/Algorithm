package SILVER;

import java.util.HashMap;
import java.util.Scanner;

public class Bacekjoon_20436 {


    static HashMap<Character, Position> hashMap;
    static class Position {
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int solution(char left, char right, String str){

        int count = 0;
        for(char now : str.toCharArray()){
            Position leftPosition = hashMap.get(left);
            Position rightPosition = hashMap.get(right);
            Position nowPosition = hashMap.get(now);

            if(checkKeyboard(now)){ //오른손
                count += (Math.abs(rightPosition.x - nowPosition.x) + Math.abs(rightPosition.y - nowPosition.y) + 1);
                right = now;
            }else{ //왼손
                count += (Math.abs(leftPosition.x - nowPosition.x) + Math.abs(leftPosition.y - nowPosition.y) + 1);
                left = now;
            }
        }

        return count;
    }

    public static boolean checkKeyboard(char c){
        Position position = hashMap.get(c);
        if(position.y >= 5){ //오른손
            return true;
        }else if(position.y == 4 && position.x == 2) {//오른손
            return  true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String arr[] = str.split(" ");
        String s = sc.nextLine();

        hashMap = new HashMap<>();
        hashMap.put('q', new Position(0,0));
        hashMap.put('w', new Position(0,1));
        hashMap.put('e', new Position(0,2));
        hashMap.put('r', new Position(0,3));
        hashMap.put('t', new Position(0,4));
        hashMap.put('y', new Position(0,5));
        hashMap.put('u', new Position(0,6));
        hashMap.put('i', new Position(0,7));
        hashMap.put('o', new Position(0,8));
        hashMap.put('p', new Position(0,9));
        hashMap.put('a', new Position(1,0));
        hashMap.put('s', new Position(1,1));
        hashMap.put('d', new Position(1,2));
        hashMap.put('f', new Position(1,3));
        hashMap.put('g', new Position(1,4));
        hashMap.put('h', new Position(1,5));
        hashMap.put('j', new Position(1,6));
        hashMap.put('k', new Position(1,7));
        hashMap.put('l', new Position(1,8));
        hashMap.put('z', new Position(2,0));
        hashMap.put('x', new Position(2,1));
        hashMap.put('c', new Position(2,2));
        hashMap.put('v', new Position(2,3));
        hashMap.put('b', new Position(2,4));
        hashMap.put('n', new Position(2,5));
        hashMap.put('m', new Position(2,6));

        int result = solution(arr[0].charAt(0), arr[1].charAt(0), s);
        System.out.println(result);

    }

}
