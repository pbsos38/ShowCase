package utility;

public class Pyramid extends Shapes {

	public Pyramid(double h, double r) {
		super(h, r);
	}

	@Override
	public double calcVolume() {
		// TODO Auto-generated method stub
		return 0.3*calcBaseArea()*h;
	}

	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return super.r*super.r;
	}
	@Override
	public String toString() {
		return String.format("\n\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Pyramid","Side Length: ",super.r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	

}
