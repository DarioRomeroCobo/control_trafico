package simulator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Junction extends SimulatedObject{
	private List<Road> incomingRoads;
	private List<List<Vehicle>> queues;
	private Map<Junction,Road> outgoingRoads;
	private Map<Road,List<Vehicle>> _queueByRoad;
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

	void addIncommingRoad(Road r) throws IllegalArgumentException  {
		if(r.destJunc.equals(this)) {
			this.incomingRoads.add(r);
			List<Vehicle> v= new ArrayList<>();
			this.queues.add(v);
			this._queueByRoad.put(r, v);
		}
		else
			throw new IllegalArgumentException("ERROR: the destJunction of the road is not equal to this junction");
	}
	
	void addOutGoingRoad(Road r) throws IllegalArgumentException{
		if(r.srcJunc.equals(r)) {
			this.outgoingRoads.put(this, r);
		}
		else
			throw new IllegalArgumentException("ERROR: the destJunction of the road is not equal to this junction");
	}
	
	void enter(Vehicle v) {
		this._queueByRoad.get(v.getRoad()).add(v);
	}
	
	Road roadTo(Junction j) {
		return this.outgoingRoads.get(j);
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
