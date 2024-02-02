package labda;

interface Reversable
{
	public String reverse(String str);
}

public class Labda2 
{

	public static void main(String[] args) 
	{
		String var = "Helloooo";
		
		Reversable v = (String str)->{
			String result = "";
			for (int i = str.length()-1; i >= 0 ; i--)
			result += str.charAt(i);
			return result;
		};
		
		System.out.println(v.reverse(var));
	}

}
