package figure_geometriche;

import java.lang.Math;

public class parallelogramma {
	private double d;
	private double D;
	private double g;
	private double h;
	private double e;
	private double a;
	private double b;

	public parallelogramma(double d, double D, double g) {
		this.d = d;
		this.D = D;
		this.g = g;
	}
	
	public double getd() {
		return d;
	}
	
	public double getD() {
		return D;
	}
		
	public double getg() {
		return g;
	}
	
	public void setd(float d) {
		this.d = d;
	}
	
	public void setD(float D) {
		this.D = D;
	}

	public void setg(float g) {
		this.g = g;
	}
	
	public double area() {
		this.calcolah();
		this.calcolae();
		this.calcolab();
		return (this.b * this.h);
	}
	
	private void calcolah() {
		this.h = this.D * Math.sin(this.g * Math.PI / 180);
	}
	
	private void calcolae() {
		this.e = Math.asin(this.h / this.d);
	}
	
	private void calcolab() {
		double t, v;
		t = Math.sqrt(Math.pow((this.D) / 2, 2) - Math.pow((this.h) / 2, 2));
		v = (this.d) / 2 * Math.cos(this.e);
		this.b = v + t;
	}
	public void latominore() {
		this.a = Math.sqrt(Math.pow((this.b) , 2) + Math.pow((this.d), 2) - (2 * (this.d * this.b) * Math.cos(this.e)));
	}

	public double perimetro() {
		this.calcolah();
		this.calcolae();
		this.calcolab();
		this.latominore();
		return ((this.b * 2) + (this.a * 2));
	}
}