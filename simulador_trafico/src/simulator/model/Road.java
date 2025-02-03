package simulator.model;

import java.util.List;

public class Road extends SimulatedObject{
	private Junction origin;
	private Junction destiny;
	private int lenght;
	private int maxSpeed;
	private int actualSpeedLimit = maxSpeed;
	private int contAlarm;
	private Weather wheather;
	private int total_cont; //Total contamination
	private List<Vehicle> vehicles;
	
	Road(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length, Weather weather) {
		  super(id);
		  // ...
		}
	
	public int getLength(){
		return this.lenght;
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
