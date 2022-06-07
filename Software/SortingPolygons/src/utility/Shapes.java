package utility;

public abstract class Shapes implements Comparable<Shapes> {
	double h;
	double r;
	
	public Shapes(double h, double r) {
		super();
		this.h = h;
		this.r = r;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	public abstract double calcVolume();
	public abstract double calcBaseArea();
	@Override
	public int compareTo(Shapes o) {
		if (o.h>this.h) 
			return 1;
		else if (this.h>o.h) 
			return -1;
		else 
			return 0;
		
	}
	
	
	
	
}
