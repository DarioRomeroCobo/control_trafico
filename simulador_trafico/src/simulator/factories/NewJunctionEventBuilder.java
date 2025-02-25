package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.model.DequeuingStrategy;
import simulator.model.LightSwitchingStrategy;
import simulator.model.NewJunctionEvent;

public class NewJunctionEventBuilder extends Builder<NewJunctionEvent> {
	private LightSwitchingStrategy lss;
	private DequeuingStrategy ds;
	
	public NewJunctionEventBuilder(Factory<LightSwitchingStrategy> lssFactory, Factory<DequeuingStrategy> dqsFactory) {
		super("new_junction","A new junction");
		lss=lssFactory.create_instance(get_info());
		ds=dqsFactory.create_instance(get_info());
	}

	@Override
	protected NewJunctionEvent create_instance(JSONObject data) {
		int time = data.getInt("time");
		String id = data.getString("id");
		
		JSONArray array = data.getJSONArray("coor");
        int x= array.getInt(0);
        int y=array.getInt(1);
        
		
		return new NewJunctionEvent(time,id,lss, ds,x,y) ;
	}

}
