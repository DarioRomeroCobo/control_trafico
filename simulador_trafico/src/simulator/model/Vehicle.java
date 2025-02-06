package simulator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
import simulator.model.SimulatedObject;
import simulator.model.VehicleStatus;

public class Vehicle extends SimulatedObject{
	private List<Junction> itinerary;
	private int maxSpeed;
	private int speed;
	private VehicleStatus status;
	private Road road;
	private int location;
	private int contClass; //Level of contamination
	private int total_cont; //Total contamination
	private int total_dist; //Total distance
	Vehicle(String id, int maxSpeed, int contClass, List<Junction> itinerary) throws IllegalArgumentException{
		  super(id);
		  if(maxSpeed > 0 && contClass >= 0 && contClass <= 10 && itinerary.size() >= 2) {
			  this.maxSpeed = maxSpeed;
			  this.contClass = contClass;
			  this.itinerary = Collections.unmodifiableList(new ArrayList<>(itinerary));
		  }
		  else throw new IllegalArgumentException("Error 404"); //Cambiar excpecion: tiene que decir lo que ha fallado
		 
		}

	

	@Override
	public JSONObject report() {
		/*
		 "id" : "v1",
		  "speed" : 20,
		   "distance" : 60,
		   "co2": 100,
		   "class": 3,
		   "status": "TRAVELING",
		   "road" : "r4",
		   "location" : 30
		   */
		return null;
	}
	
	protected void setSpeed(int s) {
		if(s < 0) {
			throw new IllegalArgumentException("ERROR: s should be positive");
		}
		else {
			this.contClass = s;
		}
	}
	
	protected void setContaminationClass(int c) {
		if(c < 0 && c >10) {
			throw new IllegalArgumentException("ERROR: c should be between 0 and 10");
		}
		else {
			if(c < this.maxSpeed) this.speed = c;
			else this.speed = this.maxSpeed;
		}
	}
	
	@Override
	protected void advance(int currTime) {
		// TODO Auto-generated method stub
		int prevLocation = this.location;
		if(this.status == VehicleStatus.TRAVELING) {
			if(this.location + this.speed < this.road.getLength()) this.location += this.speed;
			else this.location = this.road.getLength();
			
			int c = this.contClass * (this.location-prevLocation);
			this.total_cont += c;
			//AÑADIR C AL GRADO DE CONTAMINACION DE LA CARRETERA;
			
			if(this.location >= this.road.getLength()){}//ENTRA EN LA COLA DE CRUCE;
		}
		
	}
	
	protected void moveToNextRoad() {
		
		//Completar cuando tengamos carretera
		
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	
	public int getContClass() {
		return this.contClass;
	}
	public VehicleStatus getStatus() {
		return this.status;
	}
	public int getTotalCO2() {
		return this.total_cont;
	}
	public List<Junction> getItinerary() {
		return this.itinerary;
	}
	public Road getRoad() {
		return this.road;
	}
	
	
	//Quitar velocidad cuando no es travelling
	
	
	

}