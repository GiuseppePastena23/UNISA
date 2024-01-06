package core;

public class Query {
    public int opNumber;
    public String name;
    public String query;
    public boolean requiresInput;
    public boolean isComplex;

    public Query(int opNumber, String name, String query, boolean requiresInput, boolean isComplex) {
        this.opNumber = opNumber;
        this.name = name;
        this.query = query;
        this.requiresInput = requiresInput;
        this.isComplex = isComplex;
    }

    public Query(int opNumber, String name, String query, boolean requiresInput) {
        this(opNumber, name, query, requiresInput, false);
    }

    public Query(int opNumber, String name, String query) {
        this(opNumber, name, query, false, false);
    }


    @Override
    public String toString() {
        return "OP" + opNumber + " - " + name;
    }

}
