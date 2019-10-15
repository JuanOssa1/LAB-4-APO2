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
	public Event() {
		Viewver origin = new Viewver(null, null, null, null, null, null, null, null);
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
	public void insert(String id, String firstName, String lastName, String email, String gender, String country, String photo, String birthday) {
		if(isEmpty()) {
			Viewver newViewver = new Viewver(id, firstName, lastName, email, gender, country, photo, birthday);
			newViewver.setLeft(new Event());
			newViewver.setRight(new Event());
			origin = newViewver;
		} else {
			if (id.compareTo(origin.getId()) > 0) {
				(origin.getRight()).insert(id, firstName, lastName, email, gender, country, photo, birthday);
			}
			if(id.compareTo(origin.getId())<0) {
				(origin.getLeft()).insert(id, firstName, lastName, email, gender, country, photo, birthday);
			}
		}
	}
	public Event searchViewverWithId(String id) {
		Event viewver = null;
		if(!isEmpty()) {
			if(id.equals(origin.getId())) {
				return this;
			} else {
				if(id.compareTo(origin.getId())>0) {
					viewver = origin.getRight().searchViewverWithId(id);
				} else {
					viewver = origin.getLeft().searchViewverWithId(id);
				}
			}
		}
		return viewver;
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
	public String showViewversOfACountry() {
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
	/*
	public void delete(String id) {
		Event deleted = searchViewver(id);
		if(!deleted.isEmpty()) {
			if(deleted.sheet() == true) {
				deleted.origin = null;
			} else {
				if((!deleted.origin.getLeft().isEmpty()) && (!deleted.origin.getRight().isEmpty())) {
					
						Viewver trim = deleted.origin.getRight().searchMin();
						deleted.origin.setBirthday(trim.getBirthday());
						deleted.origin.setEmail(trim.getEmail());
						deleted.origin.setFirstName(trim.getFirstName());
						deleted.origin.setGender(trim.getGender());
						deleted.origin.setId(trim.getId());
						deleted.origin.setLastName(trim.getLastName());
						deleted.origin.setLeft(trim.getLeft());
						deleted.origin.setType(trim.getType());
					} else {
						if(deleted.origin.getLeft().isEmpty()) {
							deleted.origin = deleted.origin.getRight().origin;
						} else {
							deleted.origin = deleted.origin.getLeft().origin;
						}
					}
				
			}
		}
	}
	*/
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
					insert(part1,part2,part3,part4,part5,part6,part7,part8);
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String alwaysBringfirst(String id) {
		String deleted = "";
		try {
			deleted = deleteCharacterOfTheListReursive( id, first);
		} catch (noCharacterFindedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleted;
	}
	
	private String deleteCharacterOfTheListReursive(String id, Competitor permanentReference) throws noCharacterFindedException {
		//permanentReference = first;
		Competitor before = null;
		Competitor after = null;
		String msg = "";
		//NarutoCharacter temporalCharacter = null;
		if(permanentReference == null) {
			return msg;
		}
			before = permanentReference.getPrevius();
			after = permanentReference.getNext();
			if(permanentReference.getId().equals(id)) {
				
				msg = permanentReference.toString();
				if(before != null && after != null) {
					before.setNext(after);
					after.setPrevius(before);
				}
				else if(before == null && after == null) {
					afterAndBeforeAreNull(permanentReference);
				}
				else if(before != null && after == null) {
					afterAreNull(permanentReference);
				}
				else if(before == null && after != null) {
					beforeAreNull(permanentReference);
				}
			}else {
				permanentReference = permanentReference.getNext();
				return deleteCharacterOfTheListReursive( id,  permanentReference);
			}
			
			
		if(msg == "") { 
			throw new noCharacterFindedException("Error!");
		}
		return msg;
	}

	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	private String showOneCharacterWithId(String id, Competitor permanentReference) throws noCharacterFindedException {
				//Competitor before = null;
				//Competitor after = null;
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
	
	
	public String deleteCharacterOfTheList(String id) throws noCharacterFindedException {
		Competitor newReference = first;
		Competitor before = null;
		Competitor after = null;
		String msg = "";
		before = newReference.getPrevius();
		after = newReference.getNext();
		//NarutoCharacter temporalCharacter = null;
		while(newReference != null) {
			if(newReference.getId().equals(id)) {
				
				msg = newReference.toString();
				
				if(before != null && after != null) {
					before.setNext(after);
					after.setPrevius(before);
				}
				else if(before == null && after == null) {
					afterAndBeforeAreNull(newReference);
				}
				else if(before != null && after == null) {
					afterAreNull(newReference);
				}
				else if(before == null && after != null) {
					beforeAreNull(newReference);
				}
			}
			newReference = newReference.getNext();
		}
		if(msg == "") {
			throw new noCharacterFindedException("Error!");
		}
		return msg;
	}
	private String afterAndBeforeAreNull(Competitor nCharacter) {
		Competitor newReference = nCharacter;
		String msg ="Eliminado:"+" "+newReference.toString();
		newReference = null;
		return msg;
	}
	private String afterAreNull(Competitor nCharacter) {
		Competitor newReference = nCharacter;
		String msg = "Eliminado:"+ " "+newReference.toString();
		Competitor newReferenceCharacter = newReference.getPrevius();
		first = newReferenceCharacter;
		first.setNext(null);
		return msg;
	}
	private String beforeAreNull(Competitor nCharacter) {
		Competitor newReference = nCharacter;
		String msg = "Eliminado:"+ " "+newReference.toString();
		Competitor newReferenceCharacter = newReference.getNext();
		first = newReferenceCharacter;
		first.setPrevius(null);
		return msg;
	}
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
	
		
 }
		 
		

	
	
	

	
	
	
	
	
	
	
	
	

