package model;

public class Competitor extends Assistant{
	
	private Competitor previus;
	private Competitor next;
	
	public Competitor(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthday) {
		super(id, firstName, lastName, email, gender, country, photo, birthday);
		
	}

	public Competitor getPrevius() {
		return previus;
	}

	public void setPrevius(Competitor previus) {
		this.previus = previus;
	}

	public Competitor getNext() {
		return next;
	}

	public void setNext(Competitor next) {
		this.next = next;
	}
	

}
