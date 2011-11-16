package cloudstudios.XApp;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cloudstudios.XClient.Channel;

public class ChannelActivity extends ViewActivity implements OnCheckedChangeListener {
	
	private Channel channel;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle b = getIntent().getExtras();
        if(b.getBoolean("input")){
        	channel = ConnectActivity.client.getInputChannel(b.getInt("number"));
        }else{
        	channel = ConnectActivity.client.getOutputChannel(b.getInt("number"));
        }
        setContentView(Vs(
        	Lin(
	        	Chk().checked(channel.getMute()).change(this),
	        	Lbl("Mute").width(200)        
	        ),
	        Lin(
	        	Lbl("Delay:").width(200),
	        	Lin(
		        	Slider().width(-1),
		        	Txt(channel.getDelay()+"").width(200)
		        ).width(-1)
	        ).width(-1)
        ));        
    }
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		channel.setMuteAsync(isChecked);		
	}
}
