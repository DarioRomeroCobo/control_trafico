package simulator.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;
import simulator.model.SimulatedObject;
import simulator.model.VehicleStatus;

public class Vehicle extends SimulatedObject{
	private List<Junction> itinerary;
	private int itineraryIndex;
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
		JSONObject report = new JSONObject();
		report.put("id", this._id);
		report.put("speed", this.speed);
		report.put("distance", this.total_dist);
		report.put("co2", this.total_cont);
		report.put("class", this.contClass);
		report.put("status", this.status.toString());
		if(!(this.status == VehicleStatus.PENDING || this.status == VehicleStatus.ARRIVED)) {
			report.put("road", this.road);
			report.put("location", this.location);
		}
		return report;
	}
	
	void setSpeed(int s) throws IllegalArgumentException {
		if(s < 0) {
			throw new IllegalArgumentException("ERROR: s should be positive");
		}
		else {
			this.speed = Math.min(s, this.maxSpeed);
		}
	}
	
	void setContaminationClass(int c)throws IllegalArgumentException {
		if(c < 0 && c >10) {
			throw new IllegalArgumentException("ERROR: c should be between 0 and 10");
		}
		else {
			this.contClass = c;
		}
	}
	
	@Override
	void advance(int currTime) {
		
		if(this.status == VehicleStatus.TRAVELING) {
			int prevLocation = this.location;
			this.location = Math.min(this.location + this.speed, this.road.getLength());
			int c = this.contClass * (this.location-prevLocation);
			this.road.addContamination(c);
			this.total_cont += c;
			if(this.location >= this.road.getLength()) {
				this.itinerary.get(this.itineraryIndex).enter(this);
				this.status=VehicleStatus.WAITING;
				this.speed=0;
				this.itineraryIndex++;
			}
		}
	}
	
	void moveToNextRoad() throws IllegalArgumentException{
		
		if(this.status == VehicleStatus.PENDING) 
			this.road = this.itinerary.get(0).roadTo(this.itinerary.get(itineraryIndex+1));
		else if(this.status == VehicleStatus.WAITING)
		this.road = this.itinerary.get(itineraryIndex).roadTo(null);
		else
			throw new IllegalArgumentException("ERROR: the vehicleStatus is not PENDING or WAITING");
			
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