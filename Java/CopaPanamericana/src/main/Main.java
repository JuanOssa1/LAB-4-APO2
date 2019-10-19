package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Event;

public class Main {
	private Scanner dataRead;
	private Event happyevent;
	public Main() {
		init();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.menu(0);
			
	}
	public void init() {
		happyevent = new Event();
		dataRead = new Scanner(System.in);
		
	}
	public void menu(int myOption) {
		int option = myOption;
		if(option == 0) {
			happyevent.addRandomly();
			showMenuOptions();
				option = dataRead.nextInt();dataRead.nextLine();
		}
		if(option == 1) {
			System.out.println("Ingrese la id del espectador que quiere buscar");
			String id = dataRead.nextLine();
			System.out.println(happyevent.searchViewverWithId(id));
			menu(0);
		}else if(option == 2) {
			System.out.println("Ingrese la id del competidor");
			String id = dataRead.nextLine();
			System.out.println(happyevent.showCompetitor(id));
			menu(0);
		}else if(option == 3) {
			System.out.println("Ingrese el nombre del pais");
			String country = dataRead.nextLine();
			System.out.println();
			menu(0);
		}else if(option == 4) {
			System.out.println("Ingrese el nombre del pais");
			String country = dataRead.nextLine();
			System.out.println(happyevent.showCompetitorsOfACountry(country));
			menu(0);
		}else if(option == 5) {
			System.out.println("Ingrese el nombre del pais");
			String country = dataRead.nextLine();
			happyevent.showViewversPosOrder(country);
			menu(0);
		}else if(option == 6) {
			//happyevent.addRandomly();
			menu(0);
		}else if(option == 7) {
			
			menu(0);
		}else if(option == 8) { 
			
			menu(0);
		}else if(option == 9) {
			
			menu(0);
		}else if(option == 10) {
			
			menu(0);
		}else if(option == 11) {
			
			menu(0);
		}else if(option == 12) {
			
			menu(0);
		}else if(option == 13) { 
			
			menu(0);
		}else if(option == 14) {
			System.out.println("No guarde");
		}
	}
	
	public void showMenuOptions(){
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  Buscar espectador por id"); 
		System.out.println("2.  Buscar competidor por id"); 
		System.out.println("3.  Indicar si un espectador se encuentra en tre los buscados"); 
		System.out.println("4.  Mostrar toda la informacion de los competidores de un pais deseado"); 
		System.out.println("5.  Mostrar toda la informacion de los espectadores de un pais deseado en forma consecutiva"); 
		System.out.println("6.  ");
		System.out.println("7.  ");
		System.out.println("8.  ");
		System.out.println("9.  ");
		System.out.println("10. ");																												
		System.out.println("11. ");
		System.out.println("12. ");
		System.out.println("13. ");
		System.out.println("14. ");	
	}
	
}





/*
package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import model.Event;
import model.noCharacterFindedException;
public class Main {
	
		private static Event  happyevent;
	

	public static void main(String[] args) throws noCharacterFindedException {
		
		happyevent = new Event();
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		happyevent.insert("123", "www", "sss", "sss", "3rf", "hoy", "s", null);
		happyevent.insert("1234", "www", "sss", "sss", "3rf", "hoy", "s", null);
		happyevent.insert("12345", "www", "sss", "sss", "3rf", "hoy", "s", null);
	//	System.out.println(happyevent.searchViewver("123"));
	//	System.out.println(happyevent.searchViewver("1234"));
	//	System.out.println(happyevent.searchViewver("12345")); 
		//happyevent.delete("1234");
		//System.out.println(happyevent.searchViewverWithId("123"));
	//	System.out.println(happyevent.searchViewverWithId("1234"));
		//System.out.println(happyevent.searchViewverWithId("12345"));
		
		
	//	happyevent.addCharacterToTheList("2", "juan", "ossa", "xaxaxa10", "marica", "31febrero", "especta");
	//	happyevent.addCharacterToTheList("3", "juan", "ossa", "xaxaxa10", "marica", "31febrero", "especta");
	//	happyevent.addCharacterToTheList("4", "juan", "ossa", "xaxaxa10", "marica", "31febrero", "especta");
	//	happyevent.addCharacterToTheList("5", "juan", "ossa", "xaxaxa10", "marica", "31febrero", "especta");
	//	happyevent.addCharacterToTheList("6", "juan", "ossa", "xaxaxa10", "marica", "31febrero", "especta"); 
		System.out.println(happyevent.showViewversOfACountry());
		//System.out.println(happyevent.showCharacters());
		//System.out.println(happyevent.alwaysBringfirst("2"));
		//System.out.println(happyevent.alwaysBringfirst("3"));
		//System.out.println(happyevent.deleteCharacterOfTheList("4"));
		//System.out.println(happyevent.alwaysBringfirst("5"));
		//System.out.println(happyevent.alwaysBringfirst("6"));
		//System.out.println(happyevent.showCharacters());
	}
}
*/