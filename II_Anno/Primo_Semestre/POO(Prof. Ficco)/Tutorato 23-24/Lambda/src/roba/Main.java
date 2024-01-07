package roba;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> asdf = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream


        asdf.stream()
                .sorted(Comparator.reverseOrder())
                .map(op)
                .forEach(System.out::println);
    }
}