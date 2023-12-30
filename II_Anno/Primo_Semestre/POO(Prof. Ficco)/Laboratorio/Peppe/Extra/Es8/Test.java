public class Test {
    public static void main(String[] args) {
        Pair <String>pair = new Pair<>("ciao", "ciao");

        System.out.println(pair.getValues().get(0) + " " + pair.getValues().get(1));
        pair.setValues("ciao", "ciao1");
        System.out.println(pair.getValues().get(0) + " " + pair.getValues().get(1));
    }
}
