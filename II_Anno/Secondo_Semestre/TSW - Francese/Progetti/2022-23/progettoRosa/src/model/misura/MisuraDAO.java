package model.misura;

import exception.GenericError;
import model.acquisto.AcquistoBean;

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

public class MisuraDAO {
    private static final String TABLE_NAME = "Misura";
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

    public void doSave(MisuraBean product) throws SQLException {
        String query = "INSERT INTO " + TABLE_NAME + " (IDMaglietta, taglia, quantita)" + " VALUES (?, ?, ?)";

        try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product.getIDMaglietta());
            preparedStatement.setString(2, product.getTaglia());
            preparedStatement.setInt(3, product.getQuantita());

            preparedStatement.executeUpdate();
        }
    }

    public void doUpdate(MisuraBean misuraBean) throws SQLException {
        String query = "UPDATE " + TABLE_NAME +
                " SET quantita = ?" +
                " WHERE IDMaglietta = ? AND taglia = ?";

        try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, misuraBean.getQuantita());
            preparedStatement.setInt(2, misuraBean.getIDMaglietta());
            preparedStatement.setString(3, misuraBean.getTaglia());

            preparedStatement.executeUpdate();
        }
    }

    public void doUpdateUtente(AcquistoBean product, String taglia) throws SQLException {
        String query = "UPDATE " + TABLE_NAME +
                       " SET quantita = quantita - ? " +
                       "WHERE IDMaglietta = ? AND taglia = ?";

        try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, product.getQuantita());
            preparedStatement.setInt(2, product.getIDMaglietta());
            preparedStatement.setString(3, taglia);

            preparedStatement.executeUpdate();
        }
    }

    public Collection<MisuraBean> doRetrieveAll(int IDMaglietta) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Collection<MisuraBean> misure = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE IDMaglietta = ?";

        try {
            connection = ds.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, IDMaglietta);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MisuraBean misuraBean = new MisuraBean();

                setMisura(resultSet, misuraBean);

                misure.add(misuraBean);
            }

        } finally {
            if (preparedStatement!= null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

        return misure;
    }

    private void setMisura(ResultSet resultSet, MisuraBean misuraBean) throws SQLException {
        misuraBean.setIDMaglietta(resultSet.getInt("IDMaglietta"));
        misuraBean.setTaglia(resultSet.getString("taglia"));
        misuraBean.setQuantita(resultSet.getInt("quantita"));
    }
}
