package simulator.control;
import java.io.InputStream;
import java.io.OutputStream;

import org.json.JSONObject;
import org.json.JSONTokener;

import simulator.factories.Factory;
import simulator.model.Event;
import simulator.model.TrafficSimulator;

public class Controller {
	private TrafficSimulator _sim;
	private Factory<Event> _eventsFactory;
	public Controller(TrafficSimulator sim, Factory<Event> eventsFactory) throws IllegalArgumentException {
		if(sim != null && eventsFactory != null) {
		  _sim = sim;
		  _eventsFactory = eventsFactory;
		}
		else throw new IllegalArgumentException("ERROR: sim or eventsFactory is null");
	}
	
	public void loadEvents(InputStream in) {
		JSONObject jo = new JSONObject(new JSONTokener(in));
		
		//factorias
	}
	
	public void run(int n, OutputStream out) {
		
	}
	
	public void reset() {
		this._sim.reset();
	}
}
