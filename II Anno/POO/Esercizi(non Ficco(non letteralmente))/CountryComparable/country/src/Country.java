
public class Country implements Comparable<Country>{
    String nome;
    Integer superficie;

    public Country(String nome, int superficie) {
        this.nome = nome;
        this.superficie = superficie;
    }

	@Override
	public int compareTo(Country o) {
		return this.superficie.compareTo(o.superficie);
	}
  
}
