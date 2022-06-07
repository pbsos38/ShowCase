package utility;

public class TriangularPrism extends Shapes {

	public TriangularPrism(double h, double r) {
		super(h, r);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return (super.r*super.r*Math.sqrt(3))/4;
	}

	@Override
	public double calcVolume() {
		// TODO Auto-generated method stub
		return (calcBaseArea()*super.h);
	}

	@Override
	public String toString() {
		return String.format("\n\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Triangular Base Prism","Radius: ",super.r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	


}
