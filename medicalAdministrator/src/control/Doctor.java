package control;

import presentation.DoctorP;

public class Doctor {
	private DoctorP presentation;
	private int doctorID;
	private String lastName;
	private String firstName;

	public Doctor() {}
	
	public Doctor(int doctorID, String lastName, String firstName) {
		presentation = new DoctorP();
		this.doctorID = doctorID;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public int getDoctorID() {return doctorID;}
	public String getLastName() {return lastName;}
	public String getFirstName() {return firstName;}
	public DoctorP getPresentation() {
		return presentation;
	}
	
	public void setDoctorID(int doctorID) {this.doctorID = doctorID;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setPresentation() {
		presentation.updateDetails(lastName, firstName);
	}
}
