package voto_studenti;
public class studente
{
    private String nome;
    private int n;
    private int[] voti=new int [10];
	
    public studente(String nome)
    {
        this.nome=nome;
	this.n=0;
	int i;
	for(i=0;i<10;1++)
	{
	    this.voti[i]=0;
	}
    }

    public int votoMassimo()
    {
	int max=voti[0];
	int i=0;
	for(i=1;i<n;i++)
	{
	    if(max<voti[i])
	        max=voti[i];
	}
	return max;
    }

    public void inserisciVoto(int voto)
    {
	voti[n]=voto;
	n++;
    }
	
    @Override
    public String toString()
    {
	String testo;
	int i;
	testo="studente (nome: " + nome + " - n: " + n + " - voti: ";
	for(i=0;i<this.n;i++)
	{
	    testo=testo + voti[i] + "; ";
	}
	testo=testo + "))";
	return testo;
    }

    public int getN()
    {
	return this.n;
    }

    public float promosso()
    {
	float m=0;
	int i;
	for(i=0;i<this.n;i++)
	{
	    m=m+voti[i];
	}
	m=m/this.n;
	return m;
    }

    public int insufficienze()
    {
	int i, ins=0;
	for(i=0;i<this.n;i++)
	{
	    if(voti[i]<=6)
		ins++;
	}
	return ins;
    }
}