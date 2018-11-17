package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.SzemelyDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Szemely;

public class SzemelyDaoImpl implements SzemelyDao {

	private Szemely createSzemely(ResultSet rs) {
		Szemely sz = null;
		try {
			sz = new Szemely();
			sz.setId(rs.getString("id"));
			sz.setVezeteknev(rs.getString("vezeteknev"));
			sz.setKeresztnev(rs.getString("keresztnev"));
			sz.setSzuletesidatum(rs.getString("szuldatum"));
		} catch (SQLException e) {
			System.err.println("Hiba a személyek kiolvasásakor." + e);
		}
		return sz;
	}

	@Override
	public ObservableList<Szemely> get() {
		String sql = "SELECT * FROM szemely";
		ObservableList<Szemely> lista = FXCollections.observableArrayList();
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Szemely sz = createSzemely(rs);
				lista.add(sz);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
		}
		return lista;
	}

	@Override
	public void add(Szemely sz) {
		String sql = "INSERT INTO szemely (id, vezeteknev, keresztnev, szuldatum) VALUES (?,?,?,?)";
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sz.getId());
			ps.setString(2, sz.getVezeteknev());
			ps.setString(3, sz.getKeresztnev());
			ps.setString(4, sz.getSzuletesidatum());
			ps.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) { //|: vagy
			System.err.println(e);
		}

	}

	@Override
	public void remove(Szemely sz) {
		String sql = "DELETE FROM szemely WHERE id= ?";
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sz.getId());
			ps.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) { //|: vagy
			System.err.println(e);
		}

	}

	@Override
	public void update(Szemely sz) {
		String sql = "UPDATE szemely SET vezeteknev = ?, keresztnev =?, szuldatum = ? WHERE id = ?";
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sz.getVezeteknev());
			ps.setString(2, sz.getKeresztnev());
			ps.setString(3, sz.getSzuletesidatum());
			ps.setString(4, sz.getId()); //where
			ps.execute();
			con.close();
		} catch (ClassNotFoundException | SQLException e) { //|: vagy
			System.err.println(e);
		}

	}

}
