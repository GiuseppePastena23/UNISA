package bean;

import java.util.Calendar;

public class CurrentTimeBean {

	private int hours;
	private int minutes;
	
	public CurrentTimeBean() {
		Calendar now = Calendar.getInstance();
		this.hours = now.get(Calendar.HOUR_OF_DAY);
		this.minutes = now.get(Calendar.MINUTE);
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	
	
}
