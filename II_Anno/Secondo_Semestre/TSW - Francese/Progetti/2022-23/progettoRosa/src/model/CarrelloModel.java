package model;

import exception.GenericError;
import model.maglietta.MagliettaBean;
import model.maglietta.MagliettaDAO;
import model.maglietta.MagliettaOrdine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrelloModel {
    private ArrayList<MagliettaOrdine> carrello;

    public CarrelloModel() {
        carrello = new ArrayList<>();
    }

    public List<MagliettaOrdine> getCarrello() {
        return carrello;
    }

    public void setCarrello(List<MagliettaOrdine> carrello) {
        this.carrello = (ArrayList<MagliettaOrdine>) carrello;
    }

    public synchronized void aggiungi(int ID, String taglia) {
        for (MagliettaOrdine m : carrello) {
            if (m.getMagliettaBean().getID() == ID &&
                m.getTaglia().equals(taglia)) {
                m.incrementaQuantita();
                return;
            }
        }

        MagliettaDAO magliettaDAO = new MagliettaDAO();

        try {
            MagliettaBean magliettaBean = magliettaDAO.doRetrieveByKey(ID);
            carrello.add(new MagliettaOrdine(magliettaBean, taglia));
        } catch (SQLException e) {
            throw new GenericError();
        }
    }

    public synchronized void setQuantita(int ID, int quantita, String taglia) {
        for (MagliettaOrdine m : carrello) {
            if (m.getMagliettaBean().getID() == ID && m.getTaglia().equals(taglia)) {
                if (m.getQuantita() <= 0 || quantita == 0)
                    carrello.remove(m);
                else
                    m.setQuantita(quantita);
                return;
            }
        }
    }

    public synchronized void rimuovi(int ID, String taglia) {
        carrello.removeIf(m -> m.getMagliettaBean().getID() == ID &&
                m.getTaglia().equals(taglia));
    }
}
