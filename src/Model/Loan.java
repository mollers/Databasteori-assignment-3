package Model;

public class Loan {
private int id;
private int copyId;
private int personId;
private String dateLoaned;
private String dataExpire;
private String dateReturned;



public Loan(int id, int copyId, int personId, String dateLoaned, String dataExpire, String dateReturned) {
	this.id = id;
	this.copyId = copyId;
	this.personId = personId;
	this.dateLoaned = dateLoaned;
	this.dataExpire = dataExpire;
	this.dateReturned = dateReturned;
}

public int getId() {
	return id;
}

public int getCopyId() {
	return copyId;
}

public int getPersonId() {
	return personId;
}

public String getDateLoaned() {
	return dateLoaned;
}

public String getDataExpire() {
	return dataExpire;
}

public String getDateReturned() {
	return dateReturned;
}

}
