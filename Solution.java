import java.util.Scanner;

class Node{
    String data;
    Node next;
    public Node(String data){
        this.data = data;
    }
}
class Stack {
    Node head;
    public String pop(){
        if (head == null){
        return null;
        }else {
            String out = head.data;
            head = head.next;
            return out;
        }
    }

    public void push(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public String peek(){
        if (head == null){
            return null;
        }else {
            return head.data;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack stack = new Stack();
        String build = "";
        String buildIn = "";
        while (true){
            String input = scan.nextLine();
            if (input.equals("<!-- end -->")) {
                break;
            } else if ((input.charAt(0) == '<' && input.charAt(input.length() - 1) == '>') && input.charAt(1) == '/') {
                if (stack.head == null){
                    System.out.println("dokumen tidak valid");
                    return;
                }
                String check = stack.peek();
                String inputCheck = input.substring(2,input.length() - 1).toLowerCase();
                if (inputCheck.equals(check.substring(1,check.length() - 1))){
                    build += buildIn;
                    stack.pop();
                    buildIn = "";
                }else {
                    System.out.println("dokumen tidak valid");
                    return;
                }
            }else if (input.charAt(0) == '<' && input.charAt(input.length() - 1) == '>'){
                stack.push(input.toLowerCase());
            } else {
                if (stack.head != null){
                    buildIn += input + "\n";
                }
            }
        }
        if (stack.head != null){
            System.out.println("dokumen tidak valid");
        }else {
            System.out.print(build);
        }
    }
}
