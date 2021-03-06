import java.util.Objects;

public class Student {

	
	// fields: first name, last name, student ID, credits, GPA
	private String firstName;
	private String lastName;
	private int studentID;
	private double gpatotal;
	private int credits;
	private double GPA;
	
	public Student(String first, String last, int id) {
		this.firstName = first;
		this.lastName = last;
		this.studentID = id;
		this.credits = 0;
		this.gpatotal = 0;
		this.GPA = 0.0;
		
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getClassStanding() {
		if (this.credits < 30) {
			return "Freshman";
		} else if (this.credits < 60) {
			return "Sophomore";
		} else if (this.credits < 90) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	
	public void submitGrade(double grade, int cred) {
		this.gpatotal += grade * cred;
		this.credits += cred;
		this.GPA = Math.round(1000 * this.gpatotal / this.credits) / 1000.0;	
	}
	
	/**
	 * computeTuition() - this method returns the total amount of tuition the student has paid. 
	 * The average cost of tuition for 1 semester in the United States is roughly $20,000. 
	 * Assume that there are 15 credit hours per semester, 
	 * and come up with a strategy to handle any "leftover" credits.
	 * 
	 * @return
	 */
	public double computeTuition() {
		int semesters = this.credits / 15;
		int extraCredits = this.credits % 15;
		double tuition = (20000.0 * semesters) + (1333.33 * extraCredits);
		return tuition;
	}
	
	/**
	 * createLegacy() - it is not unusual for two students to meet at college, get married, start a family, 
	 * and send their children to the same school. This method should take a Student object as a parameter then create a new Student object based on the following criteria:
	 * Use one parent's full name as the baby's first name, the other parent's full name as the baby's last name
	 * Assign the baby a student ID that is the sum of its parents IDs.
	 * The legacy's estimated GPA will be the average of its parents GPA.
	 * The legacy's estimated number of credits will be the maximum of its parents credits
	 * Hint: it may be useful to create an additional constructor!
	 * 
	 */
	public static Student createLegacy(Student q, Student s) {
		Student bb = new Student("", "", 0);
		bb.setFirstName(q.firstName + " " + q.lastName);
		bb.setLastName(s.firstName + " " + s.lastName);
		bb.setStudentID(q.studentID + s.studentID);
		bb.setGPA((q.GPA + s.GPA) / 2.0);
		bb.setCredits(Math.max(q.credits, s.credits));
		return bb;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.studentID;
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
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}


	@Override
	public boolean equals(Object o) {
		// reference
		if (this == o) return true;
		// null
		if (o == null) return false;
		// type
		if (!(o instanceof Student)) return false;
		// cast
		Student s = (Student) o;
		// field check
		return Objects.equals(firstName, s.firstName) && Objects.equals(lastName, s.lastName) && Objects.equals(studentID, s.studentID);

	}
	
	
	
}
	

