package model.acquisto;

import exception.GenericError;
import model.DAOInterface;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class AcquistoDAO implements DAOInterface<AcquistoBean, Integer> {
    private static final String TABLE_NAME = "Acquisto";
    private static final DataSource ds;

    // Connessione database
    static {
        try {
            Context init = new InitialContext();
            Context env = (Context) init.lookup("java:comp/env");

            ds = (DataSource) env.lookup("jdbc/whiTee");
        } catch (NamingException e) {
            throw new GenericError();
        }
    }

    @Override
    public AcquistoBean doRetrieveByKey(Integer code) throws SQLException {
        AcquistoBean acquistoBean = new AcquistoBean();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE IDAcquisto = ?";

        try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();

            setAcquisto(resultSet, acquistoBean);
        }

        return acquistoBean;
    }

    public Collection<AcquistoBean> doRetrieveByOrdine(Integer codeOrdini) throws SQLException {
        Collection<AcquistoBean> acquisti = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE IDOrdine = ?";

        try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, codeOrdini);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AcquistoBean acquistoBean = new AcquistoBean();
                setAcquisto(resultSet, acquistoBean);
                acquisti.add(acquistoBean);
            }
        }

        return acquisti;
    }

    @Override
    public Collection<AcquistoBean> doRetriveAll(String order) {
        return null;
    }

    @Override
    public void doSave(AcquistoBean acquistoBean) throws SQLException {
        String query =  "INSERT INTO " + TABLE_NAME + " (IDOrdine, IDMaglietta, quantita, immagine, prezzoAq, ivaAq, taglia) "+
                        "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            setAcquistoStatement(acquistoBean, preparedStatement);

            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void doUpdate(AcquistoBean product) {

    }

    @Override
    public boolean doDelete(Integer code) {
        return false;
    }

    private void setAcquisto(ResultSet resultSet, AcquistoBean acquistoBean) throws SQLException {
        acquistoBean.setIDAcquisto(resultSet.getInt("IDAcquisto"));
        acquistoBean.setIDOrdine(resultSet.getInt("IDOrdine"));
        acquistoBean.setIDMaglietta(resultSet.getInt("IDMaglietta"));
        acquistoBean.setQuantita(resultSet.getInt("quantita"));
        acquistoBean.setImmagine(resultSet.getString("immagine"));
        acquistoBean.setPrezzoAq(resultSet.getFloat("prezzoAq"));
        acquistoBean.setIvaAq(resultSet.getInt("ivaAq"));
        acquistoBean.setTaglia(resultSet.getString("taglia"));
    }

    private void setAcquistoStatement(AcquistoBean acquistoBean, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, acquistoBean.getIDOrdine());
        preparedStatement.setInt(2, acquistoBean.getIDMaglietta());
        preparedStatement.setInt(3, acquistoBean.getQuantita());
        preparedStatement.setString(4, acquistoBean.getImmagine());
        preparedStatement.setFloat(5, acquistoBean.getPrezzoAq());
        preparedStatement.setInt(6, acquistoBean.getIvaAq());
        preparedStatement.setString(7, acquistoBean.getTaglia());
    }
}
