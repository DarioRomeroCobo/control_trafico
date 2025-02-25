package simulator.factories;

import org.json.JSONObject;

import simulator.model.NewCityRoadEvent;
import simulator.model.Weather;

public class NewCityRoadEventBuilder extends NewRoadEventBuilder{

	public NewCityRoadEventBuilder() {
		super("new_city_road", "A new city road");
	}

	@Override
	protected NewCityRoadEvent create_instance(JSONObject data) {
		super.inicialize(data);
		return new NewCityRoadEvent(time,id,src,dest,length,co2limit,maxSpeed,weather);
	}

}
