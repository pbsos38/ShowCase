package utility;

public class PentagonalPrism extends Shapes {

	public PentagonalPrism(double h, double r) {
		super(h, r);
	}

	@Override
	public double calcBaseArea() {
		return (5*super.r*super.r*Math.tan(Math.toRadians(54))/4);
	}

	@Override
	public double calcVolume() {
		return calcBaseArea()*super.h;
	}


	@Override
	public String toString() {
		return String.format("\n\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Pentagon Base Prism","Side Length: ",super.r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	

	

}
