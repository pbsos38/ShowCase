package utility;

import java.util.Comparator;
public class BaseAreaComparator implements Comparator<Shapes>{

	@Override
	public int compare(Shapes o1, Shapes o2) {
		if (o1.calcBaseArea() < o2.calcBaseArea()) {
			return 1;
		} else if (o1.calcBaseArea() > o2.calcBaseArea()) {
			return -1;
		} else 
		{
			return 0;
		}
	}

}
