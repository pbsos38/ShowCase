package utility;

public class Cone extends Shapes {
	private double h;
	private double r;
	public Cone(double h, double r) {
		super(h, r);
		this.h = h;
		this.r = r;
		
	}

	@Override
	public double calcBaseArea() {
		// TODO Auto-generated method stub
		return Math.PI * (Math.pow(super.r, 2));
	}

	@Override
	public double calcVolume() {
		// TODO Auto-generated method stub
		return  (Math.PI * (Math.pow(super.r, 2) * super.h))/3;
	}

	@Override
	public String toString() {
		return String.format("\n%-15s\n\t%-15s%-5.3f\n\t%-15s%-5.3f\n\t%-15s%-5.3f","Cone","Radius: ",super.r,"Area: ",calcBaseArea(),"Volume: ",calcVolume());
	}	
	
	
}
