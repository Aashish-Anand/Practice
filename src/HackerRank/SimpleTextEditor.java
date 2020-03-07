package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * In this challenge, you must implement a simple text editor.
 * Initially, your editor contains an empty string,S.
 * You must perform Q operations of the following  types:
 * <p>
 * append(W) - Append string W to the end of S.
 * delete(k) - Delete the last k characters of S.
 * print(k) - Print the Kth  character of S.
 * undo() - Undo the last (not previously undone) operation of type 1 or 2, reverting S to the state it was in prior to that operation.
 */


public class SimpleTextEditor {

    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        /*
        If we used the scanner then it was failing in TLE so we used the BufferedReader
         */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> s = new Stack<>();
        int k = -1;
        String abc = "";
        s.push(abc);
        do {
            System.out.println("1. Append");
            System.out.println("2. Delete");
            System.out.println("3. Print");
            System.out.println("4. Undo");
            String inp = sc.readLine();
            String arr[] = inp.split(" ");
            int choice = Integer.parseInt(arr[0]);

            switch (choice) {
                case 1:
                    abc += arr[1];
                    System.out.println(abc);
                    s.add(abc);
                    break;
                case 2:
                    k = Integer.parseInt(arr[1]);
                    abc = abc.substring(0, abc.length() - k);
                    s.add(abc);
                    System.out.println(abc.toString());
                    break;
                case 3:
                    k = Integer.parseInt(arr[1]);
                    System.out.println(abc.charAt(k - 1));
                    System.out.println(abc.toString());
                    break;
                case 4:
                    abc = s.pop();
                    System.out.println(s.peek());
                    break;
                default:
                    break;
            }
            System.out.println("-1 for Continue");
        } while (true);
    }
}
