package utility;

public class OctagonalPrism extends Shapes {

	public OctagonalPrism(double h, double r) {
		super(h, r);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * (Math.pow(super.r, 2));
	}

	@Override
	public double calcVolume() {
		return calcBaseArea()*super.h;
	}

	@Override
	public String toString() {
		return String.format("\n\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Octagon Base Prism","Side Length: ",super.r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	
	

}
