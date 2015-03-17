package hello;

public class employee {
	private int id;
	private String name;
	private String email;
	private String test;
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return email;
	}


	
	public employee(int id, String name,String email){
		this.id=id;
		this.email=email;
		this.name=name;
	}
}
