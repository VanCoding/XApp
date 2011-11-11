package cloudstudios.XApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import cloudstudios.XClient.Channel;
import cloudstudios.XClient.Client;

public class ControlActivity extends ViewActivity implements OnSeekBarChangeListener, OnCheckedChangeListener {
	private ArrayList<SeekBar> bars = new ArrayList<SeekBar>();
	private ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
	private ArrayList<Txt> fields = new ArrayList<Txt>();
	private ArrayList<Channel> channels = new ArrayList<Channel>();
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
        	Channel cl = ConnectActivity.client.getInputChannel(i);
        	channels.add(cl);
        	m.addView(Channel(cl));
        	m.addView(Lin().height(1).width(-1).color(0xff333333));
        }
        for(int i = 0; i < client.getOutputChannelCount(); i++){
        	Channel cl = ConnectActivity.client.getOutputChannel(i);
        	channels.add(cl);
        	m.addView(Channel(cl));
        	m.addView(Lin().height(1).width(-1).color(0xff333333));
        }       
    }
	
	
	
	public Lin Channel(Channel c){
		/*
    	Slider s;
    	Txt t;
    	CheckBox cb;
    	Lin channel = Lin(
    		cb = Chk(),
    		Lbl((c.getInput()?"IN ":"OUT ")+c.getNumber()).width(75),
    		s = Slider().width(250),
    		t = Txt("0").width(75).textsize(10)
    		
    	).gravity(16).height(50);
    	
    	cb.setChecked(c.getMute());
    	t.setInputType(2);
    	   	
    	s.setOnSeekBarChangeListener(this);
    	cb.setOnCheckedChangeListener(this);
    	
    	bars.add(s);
    	fields.add(t);
    	boxes.add(cb);*/  
		
		Lin channel = Lin(
			Lbl((c.getInput()?"IN ":"OUT ")+c.getNumber()).bold(true)
		).height(100).gravity(16).padding(20);
    	return channel;
    }

	public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
		fields.get(bars.indexOf(seekBar)).setText(progress+"");
	}

	public void onStartTrackingTouch(SeekBar seekBar) {}
	public void onStopTrackingTouch(SeekBar seekBar) {}



	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {		
		channels.get(boxes.indexOf(arg0)).setMute(arg1);
	}
}
