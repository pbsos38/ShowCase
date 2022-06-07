package utility;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Shapes>{

	@Override
	public int compare(Shapes o1, Shapes o2) {
		if (o1.calcVolume() < o2.calcVolume()) {
			return 1;
		} else if (o1.calcVolume() > o2.calcVolume()) {
			return -1;
		} else 
		{
			return 0;
		}
	}

}
