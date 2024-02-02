package core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class MedSystem 
{
	private ArrayList<Medicinale> medicinali;

	public MedSystem(ArrayList<Medicinale> medicinali) 
	{
		this.medicinali = medicinali;
	}

	public ArrayList<Medicinale> getMedicinali() {
		return medicinali;
	}

	public void setMedicinali(ArrayList<Medicinale> medicinali) {
		this.medicinali = medicinali;
	}
	
	public void printExpiredByCompany(String company)
	{
		Predicate<Medicinale> pred = m -> m.getDataScadenza().after(new GregorianCalendar()) && m.getAzienda().equalsIgnoreCase(company);
		
		this.medicinali.stream().filter(pred).forEach(System.out::println);
	}
	
	public void printSperimentalIntermed()
	{
		Predicate<Medicinale> pred = m -> ((MedicinaleSperimentale) m).getStato() == MedicinaleSperimentale.INTERMEDIO;
		
		int count = (int) this.medicinali.stream().filter(MedicinaleSperimentale.class::isInstance).filter(pred).count();
		
		System.out.println(count);
	}
	
	public void printMinMax()
	{
		Medicinale min = this.medicinali.stream().min(Comparator.comparing(Medicinale::getNumUnita)).orElse(null);
		if(min != null) System.out.println("\n\nMin: " + min.getNumUnita());
		
		Medicinale max = this.medicinali.stream().max(Comparator.comparing(Medicinale::getNumUnita)).orElse(null);
		if(max != null) System.out.println("\n\nMax: " + max.getNumUnita());
	}
	
	public void printOrderedByName()
	{
		Comparator<Medicinale> comp = (m1,m2) -> m1.getNome().compareToIgnoreCase(m2.getNome());
		
		this.medicinali.stream().sorted(comp).forEach(System.out::println);
	}
}
