package control;

public class Patient {
	private int patientID;
	private String lastName;
	private String firstName;

	public Patient() {
		patientID = -1;
		lastName = new String();
		firstName = new String();
	}

	public Patient(int patientID, String lastName, String firstName) {
		this.patientID = patientID;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	public int     getPatientID()            { return patientID;            }
    public String  getLastName()             { return lastName;             }
    public String  getFirstName()            { return firstName;            }

    public void setPatientID(int patientID)                     { this.patientID      = patientID;         }
    public void setLastName(String lastName)                    { this.lastName       = lastName;          }
    public void setFirstName(String firstName)                  { this.firstName      = firstName;         }

    @Override
    public String toString()
    {
       return lastName + " " + firstName;
    }
}
