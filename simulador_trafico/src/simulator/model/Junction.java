package simulator.model;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Junction extends SimulatedObject{
	private List<Road> incomingRoads;
	private Map<Junction,Road> outgoingRoads;
	private Map<Road,List<Vehicles> _outRoadByJunction
	private List<List<Vehicle>> queues;
	private int greenLightIndex;
	private int lastSwitchingTime;
	private LightSwitchingStrategy lsStrategy;
	private DequeuingStrategy dqStrategy;
	private int x;
	private int y;
	
	Junction(String id, LightSwitchingStrategy lsStrategy, DequeuingStrategy dqStrategy, int xCoor, int yCoor) throws IllegalArgumentException{
		super(id);
		if(!lsStrategy.equals(null) && !dqStrategy.equals(null) && xCoor > 0 && yCoor > 0) {
		  
		  this.lastSwitchingTime = 0;
		  this.lsStrategy = lsStrategy;
		  this.dqStrategy = dqStrategy;
		  this.x = xCoor;
		  this.y = yCoor;
		}
		else throw new IllegalArgumentException("Error 404"); //Cambiar excpecion: tiene que decir lo que ha fallado
	}

	void addIncommingRoad(Road r) {
		
		
	}
	
	void addOutGoingRoad(Road r) {
		
		
	}
	
	void enter(Vehicle v) {
		
		
	}
	
	Road roadTo(Junction j) {
		return null;
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
