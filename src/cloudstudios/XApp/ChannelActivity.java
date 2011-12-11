package cloudstudios.XApp;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import cloudstudios.XClient.Channel;

public class ChannelActivity extends ViewActivity implements OnCheckedChangeListener, OnSeekBarChangeListener {
	
	private Slider sDelay,sLevel;
	private Lbl tDelay,tLevel;
	
	
	private Channel channel;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle b = getIntent().getExtras();
        if(b.getBoolean("input")){
        	channel = ConnectActivity.client.getInputChannels()[b.getInt("number")];
        }else{
        	channel = ConnectActivity.client.getOutputChannels()[b.getInt("number")];
        }        
                
        setContentView(Vs(
        	Lin(
	        	Chk().checked(channel.getMute()).change(this),
	        	Lbl("Mute").width(200)        
	        ),	        
	        Lbl("Level (dB)"),
	        Lin(	        	
	        	sLevel = Slider().width(0.8).max(220).seeked(this).progress(channel.getLevel()),
	        	tLevel = Lbl("").width(100).textsize(12).padding(10)
	        ).gravity(16),
	        Lbl("Delay (ms)"),
	        Lin(	        	
	        	sDelay = Slider().width(0.8).max(62400).seeked(this).progress(channel.getDelay()),
	        	tDelay = Lbl("").width(100).textsize(12).padding(10)
	        ).gravity(16)        
        ));
        
        onProgressChanged(sDelay,channel.getDelay(),false);
        onProgressChanged(sLevel,channel.getLevel(),false);
    }
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		channel.setMute(isChecked);		
	}
	public void onProgressChanged(SeekBar s, int progress, boolean fromUser) {
		if(s == sDelay){
			tDelay.setText(Math.round((progress*100)/96.0)/100.0+"");
		}else if(s == sLevel){
			tLevel.setText(Math.round((progress*100)/4.0)/100.0-40.0+"");
		}
	}
	public void onStartTrackingTouch(SeekBar seekBar) {}
	public void onStopTrackingTouch(SeekBar s) {
		if(s == sDelay){
			channel.setDelay(sDelay.getProgress());
		}else if(s == sLevel){
			channel.setLevel(sLevel.getProgress());
		}
	}
}
