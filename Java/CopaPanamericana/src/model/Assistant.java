package model;

public abstract class Assistant {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	
	public Assistant(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthday) {
		super();
		this.id = id; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getType() {
		return country;
	}

	public void setType(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return id + "," + firstName + "," + lastName + "," + email
				+ "," + gender + "," + birthday + "," + country + ","+ photo +"," + birthday ;
	}
	
	

}
