package simulator.factories;

import org.json.JSONObject;

import simulator.model.LightSwitchingStrategy;
import simulator.model.RoundRobinStrategy;

public class RoundRobinStrategyBuilder extends Builder<LightSwitchingStrategy>{

	public RoundRobinStrategyBuilder(String typeTag, String desc) {
		super(typeTag, desc);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected LightSwitchingStrategy create_instance(JSONObject data) {
		int timeSlot;
		if(data.has("timeslot")) {
			timeSlot = data.getInt("timeslot");
		}
		else timeSlot = 1;
		return new RoundRobinStrategy(timeSlot);
	}
	
	@Override
	protected void fill_in_data(JSONObject o) {
		o.put("timeslot", 1);
	}

}
