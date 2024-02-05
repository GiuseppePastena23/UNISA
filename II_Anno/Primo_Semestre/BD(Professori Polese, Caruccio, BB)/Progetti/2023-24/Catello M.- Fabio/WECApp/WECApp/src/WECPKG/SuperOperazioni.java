package WECPKG;

import WECPKG.Componenti.Componente;
import WECPKG.Utilities.Connessione;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface SuperOperazioni {
    public static boolean register_scuderia(String nome_scuderia, String sede_scuderia, Connection con) //Operazione 1
    {
        return false;
    }

    public static boolean register_vettura(int id_gara, String modello, String rif_scuderia, ArrayList<Componente> list, Connessione con) //Operazione 2
    {
        return false;
    }

   public static boolean add_pilota_AM(String nome, String cognome, String data_nascita, String nazionalità, String data_prima_licenza, boolean gm, int rif_equipaggio, Connessione con){
        return false;
   }

   public static boolean register_componente(Componente componente, Connessione con){
        return false;
   }
    public static boolean register_finanzia(double importo, String data_fin, String rif_scuderia, String rif_gm_nome, String rif_gm_cognome, String rif_gm_data_nascita) //Operazione 4
    {
        return false;
    }

    public static String find_scuderia(String nome, String cognome, String data_nascita, Connessione con){
        return "";
    }
    public static boolean sign_vettura(int rif_vettura, int codice_gara) //Operazione 5
    {
        return false;
    }

    public static boolean add_result(int posizione, int punti, int rif_vettura, int codice_gara, Connessione con) //Operazione 6.1
    {
        return false;
    }

    public static boolean check_componente(int rif_vettura, Class<? extends Componente> tipo, Connessione con) //Operazione 7
    {
        return false;
    }

    public static boolean check_partecipazione(int rif_vettura,int codice_gara){
        return false;
    }
    public static ResultSet get_finanziamenti() //Operazione 8
    {
        return null;
    }

    public static ResultSet get_scuderie() //Operazione 9
    {
        return null;
    }

    public static ResultSet get_piloti_casa() //Operazione 10
    {
        return null;
    }

    public static ResultSet get_gm() //Operazione 11
    {
        return null;
    }

    public static ResultSet get_costruttori() //Operazione 12
    {
        return null;
    }

    public static ResultSet get_classifica_finale() //Operazione 13
    {
        return null;
    }

    public static ResultSet get_classifica_parziale()//Operazione 14
    {
        return null;
    }

    public static ResultSet get_report() //Operazione 15
    {
        return null;
    }
    public static int updatePartecipazione(int posizione, int punti, String motivoRitiro, int refVettura, int refGara, Connessione connessione) {return 0;}


}
