package bean;

public class StudentBean implements java.io.Serializable {
	private String id = null;
	private String firstName = null;
	private String lastName = null;
	private int age = 0;
	private boolean inCourse = false;

	private String[] exams = null;

	public StudentBean() {
		this.exams = new String[30];
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isInCourse() {
		return inCourse;
	}

	public void setInCourse(boolean inCourse) {
		this.inCourse = inCourse;
	}	
	
	public String getExam(int index) {
		return exams[index];
	}
	
	public void setExam(int index, String exam) {
		this.exams[index] = exam;
	}	
}



