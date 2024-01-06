import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Lambda {
    public static void main(String[] args) {
        UnaryOperator<String> reverser = (str) -> {
            StringBuilder s = new StringBuilder();
            for (int i = str.length()-1; i >= 0; i--) {
                s.append(str.charAt(i));
            }
            return s.toString();
        };

        System.out.println(reverser.apply("ABC"));
    }
}
