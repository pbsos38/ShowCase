package utility;

public class SquarePrism extends Shapes{

	public SquarePrism(double h, double s) {
		super(h, s);
	}

	@Override
	public double calcVolume() {
		return (super.r*super.r*super.h);
	}

	@Override
	public double calcBaseArea() {
		return (super.r*super.r);
	}

	@Override
	public String toString() {
		return String.format("\n\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Square Base Prism","Side Length: ",super.r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	
	

}
