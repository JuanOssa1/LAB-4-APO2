package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Event {
	private Competitor first;
	private Viewver origin;
	public static String FLATCLUBES = "data//Clubes.txt";
	String[] levelTree;
	public Event() {
		origin = null;
		//loadClub();
		// TODO Auto-generated constructor stub
	}
	public Competitor getFirst() {
		return first;
	}
	public void setFirst(Competitor first) {
		this.first = first;
	}
	public Viewver getOrigin() {
		return origin;
	}
	public void setOrigin(Viewver origin) {
		this.origin = origin;
	}
	public String getDato() {
		return origin.getId();
	}
	public boolean isEmpty() {
		return (origin == null);
	}
	
	@Override
	public String toString() {
		return origin +"";
	}
	public void insertViewver(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
		Viewver newViewver = new Viewver(id, firstName, lastName, email, gender, country, photo, birthday);
		if(origin == null) {
			origin = newViewver;
		} else {
			insertViewver(origin, newViewver);
		}
	}
	private void insertViewver(Viewver currentRoot, Viewver newViewver) {
		if(currentRoot.getId().compareTo(newViewver.getId())>0) {
			if(currentRoot.getLeft() == null) {
				currentRoot.setLeft(newViewver);
			} else {
				insertViewver(currentRoot.getLeft(), newViewver);
			}
		} else {
			if(currentRoot.getRight() == null) {
				currentRoot.setRight(newViewver);
			} else {
				insertViewver(currentRoot.getRight(), newViewver);
			}
		}
	}
	public String searchViewverWithId(String id) {
		String msg = "";
		if(origin != null) {
			if(id.equals(origin.getId())) {
				msg = origin.toString();
			} else {
				msg = searchViewverWithId(origin, id);
			}
		}
		return msg;
	}
	private String searchViewverWithId(Viewver currentRoot, String id) {
		String msg = "";
		if(currentRoot.getId().compareTo(id)<0) {
			if(currentRoot.getRight() != null) {
				if(currentRoot.getRight().getId().equals(id)) {
					msg = currentRoot.getRight().toString();
				} else {
					msg = searchViewverWithId(currentRoot.getRight(), id);
				}
			} else {
				msg = "No existe esa id";
			}
		}else {
			if(currentRoot.getLeft() != null) {
				if(currentRoot.getLeft().getId().equals(id)) {
					msg = currentRoot.getLeft().toString();
				} else {
					msg = searchViewverWithId(currentRoot.getLeft(), id);
				} 
			} else {
				msg = "No existe esa id"; 
			}
		}
		return msg;
	}
	public String showCompetitorsOfACountry(String country) {
		Competitor newReference = first;
		String msg = "";
		while(newReference != null) {
			if(newReference.getCountry().equals(country)) {
				msg += newReference.toString() + "||---->||";	
			}
			
			newReference = newReference.getNext();
		}
		if(msg == "") {
			msg = "No encontre nada!";
		}
		return msg;
	}
	public void showViewversPosOrder(String country) {
		showViewversPosOrder(origin, country);
	}
	private void showViewversPosOrder(Viewver view, String country) {
		if (view != null) {
			view.getLeft();
			showViewversPosOrder(view.getLeft(), country);
			view.getRight();
			showViewversPosOrder(view.getRight(), country);
				if(view.getCountry().equals(country)){
					System.out.print(view.toString() + "\n");
				} else {
					System.out.print("");
				}
			}
		
	}
	
	public String printlViewvers() {
		return printLevel(origin, ""); 
	}
	private String printLevel(Viewver view, String msg) {
		String info = "";
		if(view != null) {
			if(view.getLeft()!= null) {
				info += view.getLeft().toString();
				if(view.getRight() != null) {
					info += view.getRight().toString(); 
				}
			}
			try {
			printLevel(origin.getLeft(), info);
			printLevel(origin.getRight(), info);
			} catch (StackOverflowError e) {
				System.out.println("Whoops se ha llenado la memoria " + "\n" ); 
			}
		}
		return info;
	}
	public String loadClub() {	
		String msg = "DATOS CARGADOS CON EXITO!!!";
		try {
			File	file = new File(FLATCLUBES);
			FileReader	frReader = new FileReader(file);
			BufferedReader	bufferRead = new BufferedReader(frReader);
			String saveString;
			while( (saveString = bufferRead.readLine()) != null){
					String[] parts = saveString.split(",");
					String part1 = parts[0];
					String part2 = parts[1];
					String part3 = parts[2];
					String part4 = parts[3];
					String part5 = parts[4];
					String part6 = parts[5];
					String part7 = parts[6];
					String part8 = parts[7];
					insertViewver(part1,part2,part3,part4,part5,part6,part7,part8);
			}	
			bufferRead.close();
			frReader.close();	
		}
		catch(Exception e){
			msg = "OH NO HA OCURRIDO UN FALLO FATAL EN LA CARGA DE DATOS!!!";
			}
		return msg;
		
		 }
	public void addCharacterToTheList(String id, String firstName, String lastName, String email, String gender,String country, String photo, String birthday)  {
		Competitor comp = new Competitor(id, firstName, lastName, email, gender, country, photo, birthday);
		if(first == null) {	
			first = comp;
		}else {
			comp.setNext(first);
			first = comp;
		}
	}
	public String showCompetitor(String id) {
		String msg = "";
		Competitor comp = null;
		try {
			comp = showOneCharacterWithId(id);
			msg = comp.toString();
		} catch (noCharacterFindedException e) {
			msg = "Esto es embarazoso al parecer ese competidor no existe!";
		}
		return msg;
	}
	private Competitor showOneCharacterWithId(String id) throws noCharacterFindedException {
		Competitor newReference = first;
		Competitor info = null;
		boolean centinel = false;
		while(newReference != null && centinel == false) {
			if(newReference.getId().equals(id)) {
				info = newReference;
				centinel = true;
			}
			newReference = newReference.getNext();
		}
		if(info == null) {
			throw new noCharacterFindedException("Error");
		}
		return info;
	}
	public void addRandomly() {
		addRandomly(origin);
	} 
	private void addRandomly(Viewver view) {
		if (view != null) {
			view.getLeft();
			addRandomly(view.getLeft());
			view.getRight();
			addRandomly(view.getRight());	
			if(Integer.parseInt(view.getId())%2 == 0){
				addCharacterToTheList(view.getId(),view.getFirstName(), view.getLastName(), view.getEmail(), view.getGender(), view.getCountry(), view.getPhoto(), view.getBirthday());
			} else {
				}
			}
		
	}
	/*
	public String showTree(String country) {
		if(origin != null) {
			
		}
		return null;
	}
	*/
} 