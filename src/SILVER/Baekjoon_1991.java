package SILVER;

import java.util.Scanner;

public class Baekjoon_1991 {

    public static Node root;
    public static String preOrderList ="";
    public static String inOrderList="";
    public static String postOrderList="";

    public static class Node{
        char data;
        Node left, right;
        public Node(char c) {
            this.data = c;
        }
    }

    public static void addNode(char data, char left_data, char right_data ) {
        if(root == null) {
            if(data != '.') root = new Node(data);
            if(left_data != '.') root.left = new Node(left_data);
            if(right_data != '.') root.right = new Node(right_data);
        }
        else {
            search(root,data,left_data,right_data);
        }
    }

    public static void search(Node r,char data, char left_data, char right_data ) {

        if(r == null) return;

        if(r.data == data) {
            if(left_data != '.') r.left = new Node(left_data);
            if(right_data != '.') r.right = new Node(right_data);
        }else {
            search(r.left, data, left_data, right_data);
            search(r.right, data, left_data, right_data);
        }
    }

    public static void preOrder(Node node) {
        preOrderList+=node.data;
        if(node.left != null) preOrder(node.left);
        if(node.right != null) preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node.left != null) inOrder(node.left);
        inOrderList+=node.data;
        if(node.right != null) inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        postOrderList+=node.data;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++) {
            String data = sc.next();
            String left = sc.next();
            String right = sc.next();

            addNode(data.charAt(0),left.charAt(0),right.charAt(0));
        }
        preOrder(root);
        inOrder(root);
        postOrder(root);
        System.out.println(preOrderList.toString());
        System.out.println(inOrderList.toString());
        System.out.println(postOrderList.toString());
    }
}


