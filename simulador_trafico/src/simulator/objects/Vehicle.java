package simulator.objects;

import java.util.List;

import org.json.JSONObject;

import simulator.model.SimulatedObject;
import simulator.model.VehicleStatus;

public class Vehicle extends SimulatedObject{
	private List<Junction> itinerary;
	private int max_vel;
	private int act_vel;
	private VehicleStatus status;
	private Road road;
	private int location;
	private int level_cont; //Level of contamination
	private int total_cont; //Total contamination
	private int total_dist; //Total distance
	
	Vehicle(String id, int maxSpeed, int contClass, List<Junction> itinerary) {
		  super(id);
		  // TODO complete
		}

	@Override
	void advance(int time) {
		// TODO Auto-generated method stub
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}

}
