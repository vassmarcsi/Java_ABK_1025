package dao;

import javafx.collections.ObservableList;
import model.Szemely;

public interface SzemelyDao {
	final String JDBC_DRIVER = "org.sqlite.JDBC";
	final String URL = "jdbc:sqlite:Szemely.db";
	
	ObservableList<Szemely> get();
	void add(Szemely sz);
	void remove(Szemely sz);
	void update(Szemely sz);
	

}
