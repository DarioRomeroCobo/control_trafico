package simulator.model;

import java.util.List;

public class MostCrowdedStrategy implements LightSwitchingStrategy{

	@Override
	public int chooseNextGreen(List<Road> roads, List<List<Vehicle>> qs, int currGreen, int lastSwitchingTime,
			int currTime) {
		if(roads.isEmpty()) return -1;
		//otra condicion
		//if(currTime- - lastSwitchingTime < timeSlot) return currGreen;
		//última condicion
		return 0;
	}

}
