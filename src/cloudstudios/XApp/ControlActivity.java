package cloudstudios.XApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import cloudstudios.XClient.*;

public class ControlActivity extends ViewActivity implements OnSeekBarChangeListener {
	private ArrayList<SeekBar> bars = new ArrayList<SeekBar>();
	private ArrayList<Txt> fields = new ArrayList<Txt>();
	private Client client;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = ConnectActivity.client;
        
        
        Lin m;
        setContentView(
        	Vs(
        		m = Lin().vertical(true)
        	)
        );        

        for(int i = 0; i < client.getInputChannelCount(); i++){
        	m.addView(Channel(ConnectActivity.client.getInputChannel(i)));
        }
        for(int i = 0; i < client.getOutputChannelCount(); i++){
        	m.addView(Channel(ConnectActivity.client.getOutputChannel(i)));
        }       
    }
	
	
	
	public Lin Channel(Channel c){
    	Slider s;
    	Txt t;
    	Lin channel = Lin(
    		Chk(),
    		Lbl("IN 1").width(75),
    		s = Slider().width(250),
    		t = Txt("0").width(75).textsize(10)
    		
    	).gravity(16).height(50);
    	
    	bars.add(s);
    	fields.add(t);
    	t.setInputType(2);
    	s.setOnSeekBarChangeListener(this);
    	
    	return channel;
    }

	public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
		fields.get(bars.indexOf(seekBar)).setText(progress+"");
	}

	public void onStartTrackingTouch(SeekBar seekBar) {}
	public void onStopTrackingTouch(SeekBar seekBar) {}
}
