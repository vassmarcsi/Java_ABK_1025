
public class Main {

	public static void main(String[] args) {
		SzemelyDB adatbazis = new SzemelyDB();

		adatbazis.addSzemely("Kiss", "Imre", "1972-09-12");

		adatbazis.removeSzemely("3");
		
		adatbazis.updateSzemely("2", "Minta", "Katalin", "1972-09-12");
		
		adatbazis.showAllSzemely();

	}

}
