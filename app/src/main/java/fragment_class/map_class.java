package fragment_class;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.go_map.R;
import com.example.go_map.map_activity.map_food_UI;

public class map_class extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater , final ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.map,container,false);
        Button map_food_act=(Button)view.findViewById(R.id.food_map);
        map_food_act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(container.getContext(),map_food_UI.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
