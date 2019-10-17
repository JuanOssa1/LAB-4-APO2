package model;

public class Viewver extends Assistant{
	private Viewver left;
	private Viewver right;
	public Viewver(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthday) {
		super(id, firstName, lastName, email, gender, country, photo, birthday);
		left = null;
		right = null;
		//id = "0";
	}
	public Viewver getLeft() {
		return left;
	}
	public void setLeft(Viewver left) {
		this.left = left;
	}
	public Viewver getRight() {
		return right;
	}
	public void setRight(Viewver right) {
		this.right = right;
	}
}
