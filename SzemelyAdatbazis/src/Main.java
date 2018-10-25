import java.util.Scanner;


public class Main {
	
	static SzemelyDB adatbazis = new SzemelyDB();
	static Scanner beolvas = new Scanner(System.in);
	public static void listaz()
	{
		adatbazis.showAllSzemely();
	}
	
	public static void hozzaad() 
	{
		System.out.println("Kérem a felhasználó vezetéknevét: ");
		String veznev = beolvas.next();
		System.out.println("Kérem a felhasználó keresztnevét: ");
		String kernev = beolvas.next();
		System.out.println("Kérem a felhasználó születési dátumát: ");
		String szuldatum = beolvas.next();
		
		adatbazis.addSzemely(veznev, kernev, szuldatum);
	}
	
	public static void torles() 
	{
		System.out.println("Kérem a felhasználó id-ját a törléshez: ");
		String id = beolvas.next();
		
		adatbazis.removeSzemely(id);
	}
	
	public static void modosit() 
	{
		System.out.println("Kérem a felhasználó id-ját a módosításhoz: ");
		String id = beolvas.next();
		System.out.println("Kérem a felhasználó vezetéknevét: ");
		String veznev = beolvas.next();
		System.out.println("Kérem a felhasználó keresztnevét: ");
		String kernev = beolvas.next();
		System.out.println("Kérem a felhasználó születési dátumát: ");
		String szuldatum = beolvas.next();
		
		adatbazis.updateSzemely(id, veznev, kernev, szuldatum);
	}

	public static void main(String[] args) {
//		SzemelyDB adatbazis = new SzemelyDB();
//		adatbazis.addSzemely("Kiss", "Imre", "1972-09-12");
//		adatbazis.removeSzemely("3");
//		adatbazis.updateSzemely("2", "Minta", "Katalin", "1972-09-12");
//		adatbazis.showAllSzemely();
		
		boolean kilep = false;
		String valasztas = null;
		
		while(kilep!=true)
		{
			System.out.println("1) Személyek kilistázása.");
			System.out.println("2) Új személy hozzáadása.");
			System.out.println("3) Személy törlése.");
			System.out.println("4) Meglévő személy módosítása.");
			System.out.println("5) Kilépés");
			
			System.out.println("Kérek egy menüpontot: ");
			valasztas = beolvas.next();
			System.out.println();
			
			switch (valasztas) {
			case "1":
				listaz();
				System.out.println();
				break;
			case "2":
				hozzaad();
				break;
			case "3":
				torles();
				break;
			case "4":
				modosit();
				break;
			case "5":
				kilep = true;
				beolvas.close();
				System.exit(0);
				break;
			default:
				System.out.println("Nem létező menüpont!");
				break;
			}
		}

	}

}
