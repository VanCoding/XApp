package cloudstudios.XApp;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import cloudstudios.XClient.Channel;

public class ChannelActivity extends ViewActivity implements OnCheckedChangeListener, OnSeekBarChangeListener {
	
	private Slider sDelay,sLevel,sGain;
	private Lbl tDelay,tLevel,tGain;
	
	
	private Channel channel;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle b = getIntent().getExtras();
        if(b.getBoolean("input")){
        	channel = ConnectActivity.client.getInputChannel(b.getInt("number"));
        }else{
        	channel = ConnectActivity.client.getOutputChannel(b.getInt("number"));
        }
        channel.load();
        
                
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
	        ).gravity(16),
	        Lbl("Gain (dB)"),
	        Lin(	        	
	        	sGain = Slider().width(0.8).max(15).seeked(this).progress(channel.getGain()),
	        	tGain = Lbl("").width(100).textsize(12).padding(10)
	        ).gravity(16)
	        
        ));
        
        onProgressChanged(sDelay,channel.getDelay(),false);
        onProgressChanged(sLevel,0,false);
    }
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		channel.setMuteAsync(isChecked);		
	}
	public void onProgressChanged(SeekBar s, int progress, boolean fromUser) {
		if(s == sDelay){
			tDelay.setText(Math.round((progress*100)/96.0)/100.0+"");
		}else if(s == sLevel){
			tLevel.setText(Math.round((progress*100)/4.0)/100.0-40.0+"");
		}else if(s == sGain){
			tGain.setText(progress*3+"");
		}
	}
	public void onStartTrackingTouch(SeekBar seekBar) {}
	public void onStopTrackingTouch(SeekBar s) {
		if(s == sDelay){
			channel.setDelayAsync(sDelay.getProgress());
		}else if(s == sLevel){
			channel.setLevelAsync(sLevel.getProgress());
		}else if(s == sGain){
			channel.setGainAsync(sGain.getProgress());
		}
	}
}
