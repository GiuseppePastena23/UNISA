import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Banca {

    protected ArrayList<Cliente> clienti;

    public Banca() {
        // Prende i dati da DB (generati random attualmente)
        this.clienti = new ArrayList<Cliente>();
        readFile();
    }

    void readFile() {
            URL path = Banca.class.getResource("clientibanca.txt");
            File myObj = new File(path.getFile());
            Scanner myReader;
            try {
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String[] split = data.split(" ");
                    this.clienti.add(new Cliente(split[0], Integer.parseInt(split[1]), split[2],
                            new ContoRisparmio(Double.parseDouble(split[3])),
                            new ContoCorrente(Double.parseDouble(split[4]))));
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    void SaveFile() {
        try {
            URL path = Banca.class.getResource("clientibanca.txt");
            File myObj = new File(path.getFile());
            FileWriter myWriter = new FileWriter(myObj);
            for (Cliente cliente : clienti) {
                myWriter.write(String.format("%s %s %s %s %s\n", cliente.getNome(), cliente.getId(), cliente.getPin(),
                        cliente.getContoRisparmio().getSaldo(), cliente.getContoCorrente().getSaldo()));
            }
            myWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
