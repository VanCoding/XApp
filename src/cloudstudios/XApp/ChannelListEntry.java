package cloudstudios.XApp;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import cloudstudios.XClient.Channel;



public class ChannelListEntry extends Lin implements android.view.View.OnTouchListener {	
	private Channel channel;
	private ChannelListActivity activity;

	public ChannelListEntry(Context context, ChannelListActivity activity, Channel channel) {
		super(context,
			new Lbl(activity.getApplicationContext()).text((channel.getInput()?"Input":"Output")+" Channel "+channel.getNumber()).bold(true)
		);
		height(100).gravity(16).padding(20).touch(this);

		this.channel = channel;
		this.activity = activity;
	}
	
	public boolean onTouch(View arg0, MotionEvent arg1) {
		if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
            arg0.setBackgroundColor(0xff6F9300);
        } else if (arg1.getAction() == MotionEvent.ACTION_UP || arg1.getAction() == MotionEvent.ACTION_OUTSIDE || arg1.getAction() == MotionEvent.ACTION_CANCEL ) {
            arg0.setBackgroundColor(0xff000000);
            if(arg1.getAction()== MotionEvent.ACTION_UP){
            	Intent i = new Intent(activity,ChannelActivity.class);
            	i.putExtra("input", channel.getInput());
            	i.putExtra("number", channel.getNumber());
            	activity.startActivity(i);  
            }
        }
		return true;
	}
	
}
