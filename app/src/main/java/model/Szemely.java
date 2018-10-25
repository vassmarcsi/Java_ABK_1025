package model;

//import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Szemely {
	private SimpleStringProperty id;
	private SimpleStringProperty vezeteknev;
	private SimpleStringProperty keresztnev;
	private SimpleStringProperty szuletesidatum;
	
	public Szemely(String id, String vezeteknev, String keresztnev, String szuletesidatum) { //kicserélem a belsejét
		//super(); //örökléshez
		this.id = new SimpleStringProperty(id);
		this.vezeteknev = new SimpleStringProperty(vezeteknev);
		this.keresztnev = new SimpleStringProperty(keresztnev);
		this.szuletesidatum = new SimpleStringProperty(szuletesidatum);
	}

	public final SimpleStringProperty idProperty() {
		return this.id;
	}
	

	public final String getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final String id) {
		this.idProperty().set(id);
	}
	

	public final SimpleStringProperty vezeteknevProperty() {
		return this.vezeteknev;
	}
	

	public final String getVezeteknev() {
		return this.vezeteknevProperty().get();
	}
	

	public final void setVezeteknev(final String vezeteknev) {
		this.vezeteknevProperty().set(vezeteknev);
	}
	

	public final SimpleStringProperty keresztnevProperty() {
		return this.keresztnev;
	}
	

	public final String getKeresztnev() {
		return this.keresztnevProperty().get();
	}
	

	public final void setKeresztnev(final String keresztnev) {
		this.keresztnevProperty().set(keresztnev);
	}
	

	public final SimpleStringProperty szuletesidatumProperty() {
		return this.szuletesidatum;
	}
	

	public final String getSzuletesidatum() {
		return this.szuletesidatumProperty().get();
	}
	

	public final void setSzuletesidatum(final String szuletesidatum) {
		this.szuletesidatumProperty().set(szuletesidatum);
	}
	

	
	
	
	

}
