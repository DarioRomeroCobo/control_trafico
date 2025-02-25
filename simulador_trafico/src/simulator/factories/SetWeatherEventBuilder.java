package simulator.factories;

import org.json.JSONObject;

import simulator.model.SetWeatherEvent;

public class SetWeatherEventBuilder extends Builder<SetWeatherEvent>{

	public SetWeatherEventBuilder(String typeTag, String desc) {
		super(typeTag, desc);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected SetWeatherEvent create_instance(JSONObject data) {
		// TODO Auto-generated method stub
		return null;
	}

}
