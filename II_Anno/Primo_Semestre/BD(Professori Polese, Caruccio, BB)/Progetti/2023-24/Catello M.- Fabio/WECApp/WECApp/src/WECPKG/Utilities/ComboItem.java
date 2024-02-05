package WECPKG.Utilities;

import java.util.ArrayList;

public class ComboItem
{
    private String key;
    private String value;
    private ArrayList<String> values;

    public ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
        this.values = null;
    }

    public ComboItem(String key, ArrayList<String> value){
        this.values = value;
        this.key = key;
        this.value = "";
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }

    public ArrayList<String> getValues() {
        return values;
    }
}
