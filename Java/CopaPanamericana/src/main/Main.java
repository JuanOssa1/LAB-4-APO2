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
			long t1 = System.nanoTime();
			System.out.println(happyevent.loadClub());
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Tiempo Ejecucion: "+save );
			menu(0);
		}
		if(option == 2) {
			System.out.println("Ingrese la id del espectador que quiere buscar");
			String id = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyevent.searchViewverWithId(id));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Tiempo Ejecucion: "+save );
			menu(0);
		}else if(option == 3) {
			System.out.println("Ingrese la id del competidor");
			String id = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyevent.showCompetitor(id));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Tiempo Ejecucion: "+save );
			menu(0);
		}else if(option == 4) {
			System.out.println("Ingrese el nombre del pais");
			String country = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyevent.printlViewvers());
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Tiempo Ejecucion: "+save );
			menu(0);
		}else if(option == 5) {
			System.out.println("Ingrese el nombre del pais");
			String country = dataRead.nextLine();
			long t1 = System.nanoTime();
			System.out.println(happyevent.showCompetitorsOfACountry(country));
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Tiempo Ejecucion: "+save );
			menu(0); 
		}else if(option == 6) {
			System.out.println("Ingrese el nombre del pais");
			String country = dataRead.nextLine();
			long t1 = System.nanoTime();
			happyevent.showViewversPosOrder(country);
			long t2 = System.nanoTime();
			long save = t2 -t1;
			System.out.println("Tiempo Ejecucion: "+save );
			menu(0);
		}else if(option == 7) {
			System.out.println("HASTA LA PROXIMA SHJKJKASSDA");
		}
	}
	public void showMenuOptions(){
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  PULSE 1 PARA CARGAR TODOS LOS DATOS NECESARIOS");
		System.out.println("2.  Buscar espectador por id"); 
		System.out.println("3.  Buscar competidor por id"); 
		System.out.println("4.  Mostrar el arbol"); 
		System.out.println("5.  Mostrar toda la informacion de los competidores de un pais deseado en forma consecutiva"); 
		System.out.println("6.  Mostrar toda la informacion de los espectadores de un pais deseado "); 
		System.out.println("7.  Salir");
	}
	
}