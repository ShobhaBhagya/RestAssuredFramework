package practice_pojo_SerDes;

public class EmpdetailsObject {

	int id;
	String name;
	int[] phno;
	String[] emailid;
	String address;
	
	
	public EmpdetailsObject(int id, String name, int[] phno, String[] emailid, String address) {
		
		this.id = id;
		this.name = name;
		this.phno = phno;
		this.emailid = emailid;
		this.address = address;
	}


	public String[] getEmailid() {
		return emailid;
	}


	public void setEmailid(String[] emailid) {
		this.emailid = emailid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int[] getPhno() {
		return phno;
	}


	public void setPhno(int[] phno) {
		this.phno = phno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
