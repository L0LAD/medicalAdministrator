package control;

import java.util.ArrayList;
import java.util.List;

import dao.DoctorDAO;
import dao.MedicalRecordException;
import control.Doctor;
import presentation.DoctorsListP;

public class DoctorsList {

	private DoctorDAO doctorDAO;
	private DoctorsListP presentation;
	private Doctor currentDoctor;

	public DoctorsList(DoctorsListP presentation) {
		doctorDAO = new DoctorDAO();
		this.presentation = presentation;
		presentation.initialize(this, getDoctorsNames());
		presentation.disableActionOnSelection();
	}

	private List<String> getDoctorsNames() {
		List<String> doctors = new ArrayList<String>();
		for (Doctor doctor : getDoctors()) {
			doctors.add(doctor.getLastName() + " " + doctor.getFirstName());
		}
		return doctors;
	}

	public List<Doctor> getDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		doctors = doctorDAO.findAll();
		return doctors;
	}

	public void selectDoctor(int selectedIndex) {
		currentDoctor = getDoctors().get(selectedIndex);
		currentDoctor.setPresentation();
		presentation.selectDoctor(currentDoctor.getPresentation());
		presentation.enableActionOnSelection();
	}

	// Désélection d'un patient
	public void selectNoDoctor() {
		currentDoctor = null;
		presentation.selectNoDoctor();
		presentation.disableActionOnSelection();
	}

	public DoctorsListP getPresentation() {
		return presentation;
	}

}
