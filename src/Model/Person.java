package Model;

public class Person {
	private int id;
	private String ZIP;
	private String city;
	private String adress;
	private String name;
	private String mail;
	private String phoneNr;
	
	public Person(int id, String zIP, String city, String adress, String name, String mail, String phoneNr) {
		this.id = id;
		this.ZIP = zIP;
		this.city = city;
		this.adress = adress;
		this.name = name;
		this.mail = mail;
		this.phoneNr = phoneNr;
	}
	public int getId() {
		return id;
	}
	public String getZIP() {
		return ZIP;
	}
	public String getCity() {
		return city;
	}
	public String getAdress() {
		return adress;
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	public String getPhoneNr() {
		return phoneNr;
	}
	
}
