package roba;

@FunctionalInterface
public interface CringeInterface {
    void run();

    default void run(int n) {
        System.out.println("Aiuto run non implementato");
    }
}
