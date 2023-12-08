package università;

import java.util.ArrayList;

public class Esame
{
    private String Nome;
    private String SSD;

    public Esame(String Nome, String SSD)
    {
        this.Nome = Nome;
        this.SSD = SSD;
    }

    public String getNome(){Return Nome;}
    public String getSSD(){Return SSD;}

    public void setNome(String Nome){this.Nome = Nome;}
    public void setSSD(String SSD){this.SSD = SSD;}

    @Override
    public String toString()
    {
        return
        (
            "Esame =\n" +
        	"Nome = " + getNome() + "\n" +
            "SSD= " + getSSD() + "\n"
        );
    }
}