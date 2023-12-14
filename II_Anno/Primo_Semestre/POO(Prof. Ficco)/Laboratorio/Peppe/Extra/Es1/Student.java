public class Student extends Person{

    protected int studentID;
    protected int grade;

    public Student(String name, int age, String gender, int studentID, int grade)
    {
        super(name, age, gender);
        this.studentID = studentID;
        this.grade = grade;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + "\nAge: " + this.age + "\nGender: " +  this.gender + "\nStudentID: " +  this.studentID + "\nGrade: " +  this.grade;
    }
    
}
