public class Student
{
   private String name;
   private int id;

   public Student(int anId) { id = anId; }
   public String getId() { return id; }
   // No setId method

   public String getName() { return name; }

   public void setName(String newName)
   {
      if (newName.length() > 0) { name = newName; }
   }
}

