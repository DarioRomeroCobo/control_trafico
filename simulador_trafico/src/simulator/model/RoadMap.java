package simulator.model;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class RoadMap {
	private List<Junction> junctionList;
	private List<Road> roadList;
	private List<Vehicle> vehicleList;
	private Map<String,Junction> junctionMap;
	private Map<String,Road> roadMap;
	private Map<String, Vehicle> vehicleMap;
	
	void addJunction(Junction j) {
		
	}
	
	void addRoad(Road r) {
		
	}
	
	void addVehicle(Vehicle v) {
		
	}
	
	public Junction getJunction(String id) {
		return null;
	}
	
	public Road getRoad(String id) {
		return null;
	}
	
	public Vehicle getVehicle(String id) {
		return null;
	}
	
	public List<Junction> getJunctions(){
		return null;
	}
	
	public List<Road> getRoads(){
		return null;
	}
	
	public List<Vehicle> getVehicles(){
		return null;
	}
	
	void reset() {
		
		
	}
	
	public JSONObject report() {
		return null;
	}
}
