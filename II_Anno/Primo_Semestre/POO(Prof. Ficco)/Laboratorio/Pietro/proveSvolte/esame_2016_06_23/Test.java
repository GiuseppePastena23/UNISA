package esame_2016_06_23;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		ProgrammazioneDidattica test = new ProgrammazioneDidattica("TestProg", 0, 1000);
		Random generatore = new Random();
		//10 triennali, 5 magistrali e 5 dottorati
		for(int i = 0; i < 10; i++) {
			int frontali = generatore.nextInt(100);
			int laboratorio = generatore.nextInt(100);
			test.add(new corsoTriennale(frontali, laboratorio, "TriName" + i, "TriTeacher" + i));
		}
		for(int i = 0; i < 5; i++) {
			int frontali = generatore.nextInt(100);
			test.add(new corsoTriennale(frontali, "MagName" + i, "MagTeacher" + i));
		}
		for(int i = 0; i < 5; i++) {
			int frontali = generatore.nextInt(100);
			int j = generatore.nextInt(2);
			String lingua;
			if(j == 0) {
				lingua = "Italiano";
			}
			else {
				lingua = "Inglese";
			}
			test.add(new corsoTriennale(frontali, lingua, "DocName" + i, "DocTeacher" + i));
		}
	new StarterGUI(test);
	}
}