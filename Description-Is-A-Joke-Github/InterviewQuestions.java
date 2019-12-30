package interviewquestions;

import java.util.Stack;

public class InterviewQuestions {

    public static void main(String[] args) {

        System.out.println(isPalendrome("Racecar"));
        System.out.println(isPalendrome("steve"));
        System.out.println(isBalancedExpression("{}{}({()})"));
        System.out.println(isBalancedExpression("((){}{}"));
        System.out.println(EvaluateExpression("42+351-*+"));
        System.out.println(EvaluateExpression("545*+5/"));

    }

    public static Boolean isPalendrome(String input) { // will check is a string given is a palendrome

        char[] chars = input.toCharArray();
        Stack<Character> mystack = new Stack<>();
        Stack<Character> mystack2 = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            mystack.add(chars[i]);
            mystack2.add(chars[chars.length - i - 1]);
        }
        while (mystack.size() > 0) {
            char PalChar = mystack.pop();
            char PalChar2 = mystack2.pop();
            String Comp1 = Character.toString(PalChar);
            String Comp2 = Character.toString(PalChar2);
            if (Comp1.equalsIgnoreCase(Comp2)) {

            } else {
                return false;
            }
        }
        return true;
    }

    public static Boolean isBalancedExpression(String input) { // will serve as a way to check is a set of peramiters will work
        char[] chars = input.toCharArray();
        Stack<Character> mystack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ('{') || chars[i] == ('(')) {
                mystack.add(chars[i]);
            } else if (chars[i] == ('}') || chars[i] == (')')) {
                if (mystack.empty()) {
                    return false;
                }

                char BalChar = mystack.pop();

                if (BalChar == '(' && chars[i] == '}' || BalChar == '{' && chars[i] == ')') {
                    return false;
                }

            }
        }
        if (mystack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static int EvaluateExpression(String input) { //this method will serve as a basic calculator.

        char[] chars = input.toCharArray();
        Stack<Integer> mystack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {

            if (Character.isDigit(chars[i])) {
                mystack.push(Character.getNumericValue(chars[i]));
            } else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                int num1 = mystack.pop();
                int num2 = mystack.pop();
                if (chars[i] == '+') {
                    mystack.push(num2 + num1);
                }

                if (chars[i] == '-') {
                    mystack.push(num2 - num1);
                }

                if (chars[i] == '*') {
                    mystack.push(num2 * num1);
                }

                if (chars[i] == '/') {
                    mystack.push(num2 / num1);
                }

            }

        }
        return mystack.pop();
    } 
}
