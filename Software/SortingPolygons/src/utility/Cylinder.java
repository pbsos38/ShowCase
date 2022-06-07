package utility;

public class Cylinder extends Shapes {

	private double r;
	private double h;
	public Cylinder(double h, double r) {
		super(h, r);
		this.h = h;
		this.r = r;
	}

	@Override
	public double calcBaseArea() {
		return (Math.PI * (Math.pow(r, 2)));
	}

	@Override
	public double calcVolume() {
		return (Math.PI * (Math.pow(r, 2)) * h);
	}

	@Override
	public String toString() {
		return String.format("\n\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Cylinder","Radius: ",r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	

}
