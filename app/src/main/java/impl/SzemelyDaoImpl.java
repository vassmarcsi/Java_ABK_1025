package impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SzemelyDao;
import javafx.collections.ObservableList;
import model.Szemely;

public class SzemelyDaoImpl implements SzemelyDao {

	private Szemely createSzemely(ResultSet rs)
	{
		Szemely sz = null;
		try 
		{
			sz = new Szemely();
			sz.setId(rs.getString("id"));
			sz.setVezeteknev(rs.getString("vezeteknev"));
			sz.setKeresztnev(rs.getString("keresztnev"));
			sz.setSzuletesidatum(rs.getString("szuletesidatum"));
		} catch (SQLException e) {
			System.err.println("Hiba a személyek kiolvasásakor."+e);
			}
		return sz;
	}
	
	@Override
	public ObservableList<Szemely> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Szemely sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Szemely sz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Szemely sz) {
		// TODO Auto-generated method stub

	}

}
