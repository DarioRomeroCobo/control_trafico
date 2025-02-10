package simulator.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

public abstract class Road extends SimulatedObject{
	protected Junction srcJunc;
	protected Junction destJunc;
	protected int lenght;
	protected int maxSpeed;
	protected int actualSpeedLimit = maxSpeed;
	protected int contLimit;    //lı́mite de contaminación 
	protected Weather weather;
	protected int total_cont; //Total contamination
	protected List<Vehicle> vehicles;
	private VehicleComparator v;
	
	Road(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length, Weather weather) throws IllegalArgumentException {
		  super(id);
		  if(maxSpeed>0 && contLimit>=0 && lenght>0 && srcJunc!=null && destJunc!=null && weather!=null) {
			  this.srcJunc=srcJunc;
			  this.destJunc=destJunc;
			  this.maxSpeed=maxSpeed;
			  this.contLimit=contLimit;
			  this.lenght=lenght;
			  this.weather=weather;
			  
		  }
		  else
			  throw new IllegalArgumentException("Error 404"); //Cambiar excpecion: tiene que decir lo que ha fallado
		}
	
	void enter(Vehicle v) throws IllegalArgumentException {
		if(v.getLocation()==0 && v.getSpeed()==0)
		vehicles.add(v);
		else throw new IllegalArgumentException("ERROR: la localización del vehı́culo no es 0 o que la velocidad del vehı́culo no es 0"); 
	}
	
	void exit(Vehicle v) {
		vehicles.remove(v);
	}
	
	void setWeather(Weather w)throws IllegalArgumentException {
		if(w!=null)
			this.weather=w;
		else throw new IllegalArgumentException("ERROR: weather es null");
	}
	
	void addContamination(int c) {
		if(c>=0)
			this.total_cont+=c;
		else throw new IllegalArgumentException("ERROR: la contaminación es negativa");
		
	}
	
	
	abstract void reduceTotalContamination();
		
	abstract void updateSpeedLimit();
	
	abstract int calculateVehicleSpeed(Vehicle v);
	
	@Override
	void advance(int time) {
		reduceTotalContamination();
		updateSpeedLimit();
		for(Vehicle v: vehicles) {
			v.setSpeed(calculateVehicleSpeed(v));
			v.advance(time);
		}
		Collections.sort(this.vehicles,v);
	}

	@Override
	public JSONObject report() {/*
		 JSONObject info = new JSONObject();
		    info.put("id", _type_tag);
		    info.put("speedlimitc", _desc);
		    JSONObject data = new JSONObject();
		    fill_in_data(data);
		    info.put("data", data);
		    return info;
		    */
		return null;
	}
	public int getLength(){
		return this.lenght;
	}
	public Junction getDest() {
		return this.destJunc;
	}
	public Junction getSrc() {
		return this.srcJunc;
	}
	public Weather getWeather() {
		return this.weather;
	}
	public int getContLimit() {
		return this.contLimit;
	}
	public int getMaxSpeed() {
		
		return this.maxSpeed;
	}
	public int getTotalCO2() {
		return this.total_cont;
	}
	public int getSpeedLimit() {
		return this.actualSpeedLimit;
	}
	public List<Vehicle> getVehicles() {
		return Collections.unmodifiableList(vehicles);
	}
	
}
