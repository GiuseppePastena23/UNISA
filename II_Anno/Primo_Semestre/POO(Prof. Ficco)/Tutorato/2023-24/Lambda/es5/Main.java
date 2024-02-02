package es5;

import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        UnaryOperator<String> reverser = (String str) -> {
            String result = "";
            for (int i = str.length()-1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        String abc = "ABC";
        System.out.println(reverser.apply(abc));
    }
}
