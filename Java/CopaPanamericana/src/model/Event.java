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
			if(currentRoot.getRight() == null) {
				currentRoot.setRight(newViewver);
			} else {
				insertViewver(currentRoot.getRight(), newViewver);
			}
		} else {
			if(currentRoot.getLeft() == null) {
				currentRoot.setLeft(newViewver);
			} else {
				insertViewver(currentRoot.getLeft(), newViewver);
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
		if(currentRoot.getId().compareTo(id)>0) {
			if(currentRoot.getRight() != null) {
				if(currentRoot.getRight().getId().equals(id)) {
					msg = currentRoot.toString();
				} else {
					msg = searchViewverWithId(currentRoot.getRight(), id);
				}
			} else {
				msg = "No existe esa id";
			}
		}else {
			if(currentRoot.getLeft() != null) {
				if(currentRoot.getLeft().getId().equals(id)) {
					msg = currentRoot.toString();
				} else {
					msg = searchViewverWithId(currentRoot.getLeft(), id);
				} 
			} else {
				msg = "No existe esa id"; 
			}
		}
		return msg;
	}
	public String searchCompetitorWithId(String id) {
		String show = "";
		try {
			show = showOneCharacterWithId( id,  first);
		} catch (noCharacterFindedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}
	public String showCompetitorsOfACountry(String country) {
		Competitor newReference = first;
		String msg = "";
		while(newReference != null) {
			msg += newReference.toString();	
			newReference = newReference.getNext();
		}
		if(msg == "") {
			msg = "No encontre nada!";
		}
		return msg;
	}
	/*
	public String showViewversOfACountry() {  ////REVISAR!////
		String info = showViewversOfACountry(origin, null, null, "");
		return info;
	}
	
	private String showViewversOfACountry(Viewver start, Viewver viewver, Viewver viewver2, String info) {
		
		if(start.getLeft()!= null) {
			info += start.getLeft().getOrigin().toString();
			showViewversOfACountry(start.getLeft().getOrigin(), start.getLeft().getOrigin(), start.getRight().getOrigin(), info );
		}
		if(start.getRight()!= null){
			info += start.getRight().getOrigin().toString();
			showViewversOfACountry(start.getLeft().getOrigin(), start.getLeft().getOrigin(), start.getRight().getOrigin(), info );
			
		}
		return info;
	}
	
	
	public boolean isSheet() {
		boolean sheet = false;
		if(origin.getLeft().isEmpty() && origin.getRight().isEmpty()) {
			sheet = true;
		}
		return sheet;
	}
	public Viewver searchMin() {
		Event search = this;
		while(!search.origin.getLeft().isEmpty()) {
			search = search.origin.getLeft();
		}
		Viewver info = search.origin;
		search.origin = null;
		return info;
	}
	*
	*/
	public void printLevel() {
		levelTree = new String
	}
	public String printlViewvers() {
		return printLevel(origin, "");
	}
	private String printLevel(Viewver view, String msg) {
		String info = "";
		if(origin != null) {
			if(origin.getLeft()!= null) {
				info += origin.getLeft().toString();
				if(origin.getRight() != null) {
					info += origin.getRight().toString(); 
				}
			} 
			printLevel(origin.getLeft(), info);
			printLevel(origin.getRight(), info);
		}
		return info;
	}
	public void loadClub() {	
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
					//insert(part1,part2,part3,part4,part5,part6,part7,part8);
			}	
			bufferRead.close();
			frReader.close();	
		}
		catch(Exception e){
			System.out.println("Ayyyy que man tan de malas");
			e.printStackTrace();
			}
		//return c;
		 }
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void addCharacterToTheList(String id, String firstName, String lastName, String email, String gender,String country, String photo, String birthday)  {
		//validateAvaiableNameForCharacter(firstName);
		Competitor comp = new Competitor(id, firstName, lastName, email, gender, country, photo, birthday);
		if(first == null) {	
			first = comp;
		}else {
			comp.setNext(first);
			first = comp;
		}
	}	
	private String showOneCharacterWithId(String id, Competitor permanentReference) throws noCharacterFindedException {
				String msg = "";
				if(permanentReference == null) {
					return msg;
				}
					if(permanentReference.getId().equals(id)) {
						msg = permanentReference.toString();	
					}else {
						permanentReference = permanentReference.getNext();
						return showOneCharacterWithId( id,  permanentReference);
					}
					
				if(msg == "") { 
					throw new noCharacterFindedException("Error!");
				}
				return msg;
				
	}
	/*
	public void randomTakerOfViewver() {
		int i = 0;
		int quantity = 50000;
		int range = 100000;
		int array[] = new int[quantity];
		array[i]=(int)(Math.random()*range+1);
		for(i = 1; i<quantity; i++) {
			array[i]=(int)(Math.random()*range+1);
			for(int j = 0; j<i; j++) {
				if(array[i]==array[j]) {
					i--;
				}
			}
		}
		
		
		for(int k=0; k<quantity; k++) {
			String randonK = String.valueOf(k);
			Viewver covertInCompetitor = searchViewverWithId(randonK).getOrigin();
			addCharacterToTheList(covertInCompetitor.getId(),covertInCompetitor.getFirstName(), covertInCompetitor.getLastName(), covertInCompetitor.getEmail(), covertInCompetitor.getGender(), covertInCompetitor.getCountry(), covertInCompetitor.getPhoto(), covertInCompetitor.getBirthday());
		}
			
		
	}
	*/
		
 }
		 
//Dudas para tutoria: Revisar el metodo buscar por id viewvers
//Mostrar arbol de viewvers


	
	
	

	
	
	
	
	
	
	
	
	

