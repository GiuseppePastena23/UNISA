package es4;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<Double> pi = () -> Math.PI;
        System.out.println(pi.get());
    }
}
