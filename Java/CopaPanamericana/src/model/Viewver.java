package model;

public class Viewver extends Assistant{

	private Event left;
	private Event right;
	
	
	public Viewver(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthday) {
		super(id, firstName, lastName, email, gender, country, photo, birthday);
		left = null;
		right = null;
		//id = "0";
	}





	public Event getLeft() {
		return left;
	}

	public void setLeft(Event left) {
		this.left = left;
	}

	public Event getRight() {
		return right;
	}

	public void setRight(Event right) {
		this.right = right;
	}

	

}
