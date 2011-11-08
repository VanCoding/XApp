package cloudstudios.XApp;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import cloudstudios.XClient.*;

public class ConnectActivity extends ViewActivity implements OnSeekBarChangeListener {
    /** Called when the activity is first created. */
	
	private Lbl label;
	private Txt ip;
	private Btn connect;
	private ArrayList<SeekBar> bars = new ArrayList<SeekBar>();
	private ArrayList<Txt> fields = new ArrayList<Txt>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Lin m;
        setContentView(
        	Vs(
        		m = Lin().vertical(true)
        	)
        );
        
        for(int i = 0; i < 16; i++){
        	m.addView(Channel(null));
        }
        
        /*
        setContentView(Lin(
        	Lbl("IP:")
        ));*/
        /*
        Lin l;
        setContentView(Vs(
        	l = Lin(
        		label = Lbl("IP:").width(100),
        		ip = Txt("192.168.1.45").width(-1)
        	),
        	Lin(
        		connect = Btn("Connect").width(200)
        	).gravity(5)
        ));
        connect.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Log.d("geil","o");
        	}
        });*/
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