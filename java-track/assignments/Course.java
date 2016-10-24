
import java.util.ArrayList;
import java.util.Objects;

public class Course {
	
	// fields : name, credits, num seats, roster of students
	private String name;
	private int credits;
	private int remainingSeats;
	private ArrayList<Student> students;
	
	private static ArrayList<Course> courses = new ArrayList<Course>();
	private static int coursesCreated;
	
	
	public Course(String name, int credits, int remainingSeats) {
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		this.students = new ArrayList<Student>();
		courses.add(this);
		coursesCreated += 1;
	}
	
	public static ArrayList<Course> getAllCourses() {
		return courses;
	}
	
	public static int getNumCoursesCreated() {
		return coursesCreated;
	}
	
	/**
	 * addStudent() - returns a boolean based on whether or not the student was successfully added to the course. 
	 * Check to make sure that the student has not already enrolled, 
	 * and update the number of seats remaining.
	 */
	
	public boolean addStudent(Student s) {
		if (this.remainingSeats < 1) {
			return false;
		}	
		if (students.contains(s)) {
			return false;
		} else {
			students.add(s);
			this.remainingSeats -= 1;
			return true;
		}
	}
	
	/**
	 * generateRoster() - Returns a String that represents a roster with all of the students in the course. 
	 * Make sure to omit "empty" seats!
	 */
	public String generateRoster() {
		String roster = "";
		for (Student s: this.students) {
			roster += s + "\n";
		}
		return roster;
	}
	
	/**
	 * averageGPA() - returns the average GPA of all students enrolled in the course. Make sure to omit "empty" seats!
	 */
	public double averageGPA() {
		double sumGPA = 0;
		for (Student s: this.students) {
			sumGPA += s.getGPA();
		}
		return sumGPA / this.students.size();
	}
	
	
	public String toString() {
		return this.name + " " + this.credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	@Override
	public boolean equals(Object o) {
		// reference equality
		if (this == o) return true;
		// null check
		if (o == null) return false;
		// type check
		if (!(o instanceof Course)) return false;
		// cast to course
		Course c = (Course) o;
		// field checks
		return Objects.equals(credits, c.credits) && Objects.equals(name, c.name) 
				&& Objects.equals(remainingSeats, c.remainingSeats) && Objects.equals(students, c.students);
	}
	
	
	
}

