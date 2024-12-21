package Strings;

import java.util.Stack;

public class ReverseStringWithoutInBuiltMethod {
    private static void reverseUsingForLoop(String str) {
        char[] strCharArray = str.toCharArray();
        StringBuilder newStr = new StringBuilder();
        for (int i = strCharArray.length - 1; i >= 0; i--) {
            newStr.append(strCharArray[i]);
        }
        System.out.println("Using loops: " + newStr);
    }

    private static void reverseUsingJava8(String str) {
        String reversed = str.chars()
                .mapToObj(c -> String.valueOf((char) c)) // Convert int to char and then to String
                .reduce((acc, ch) -> ch + acc) // Reverse by accumulating in reverse order
                .orElse("");
        System.out.println("Using Java8: " + reversed);
    }

    private static void reverseUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
//        pushing to stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
//        poping data from stack and append to string
        StringBuilder result = new StringBuilder(str.length());
        while (!stack.empty()) {
            result.append(stack.pop());
        }

        System.out.println("Using Stack: " + result);
    }

    private static void reverseUsingTwoPointer(String str){
        char[] strCharArray = str.toCharArray();
        int left = 0;
        int right = strCharArray.length - 1;

        while (left <right){
//            swapping characters
            char temp = strCharArray[left];
            strCharArray[left] = strCharArray[right];
            strCharArray[right] = temp;
            left++;
            right--;
        }

        System.out.println("using Two pointer technique: "+ new String(strCharArray));

    }

    public static void main(String[] args) {
        String str = "Shreyas";
        reverseUsingForLoop(str);
        reverseUsingJava8(str);
        reverseUsingStack(str);
        reverseUsingTwoPointer(str);
    }
}
