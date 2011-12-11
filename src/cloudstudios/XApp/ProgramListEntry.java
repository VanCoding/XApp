package cloudstudios.XApp;

import cloudstudios.XClient.ClientEventReceiver;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

public class ProgramListEntry extends Lin implements android.view.View.OnTouchListener, ClientEventReceiver {

	private ProgramListActivity activity;
	private int program;
	private ProgressDialog progress;

	public ProgramListEntry(Context context, ProgramListActivity activity, int program, String name) {
		super(context,
			new Lbl(activity.getApplicationContext()).text((program+1)+": "+name).bold(true)
		);
		height(100).gravity(16).padding(20).touch(this);

		this.program = program;
		this.activity = activity;
	}

	public boolean onTouch(View arg0, MotionEvent arg1) {
		if(arg1.getAction() == MotionEvent.ACTION_DOWN) {
            arg0.setBackgroundColor(0xff6F9300);
        } else if (arg1.getAction() == MotionEvent.ACTION_UP || arg1.getAction() == MotionEvent.ACTION_OUTSIDE || arg1.getAction() == MotionEvent.ACTION_CANCEL ) {
            arg0.setBackgroundColor(0xff000000);
            if(arg1.getAction()== MotionEvent.ACTION_UP){
            	
            	if(activity.getIntent().getExtras().getString("mode").equals("Save")){
            		ConnectActivity.client.saveProgram(program);
            		activity.startActivity(new Intent(activity,ChannelListActivity.class));
            	}else{
            		ConnectActivity.client.setEventReceiver(this);
            		ConnectActivity.client.loadProgram(program);
            		progress = ProgressDialog.show(activity, "Loading Program...","Loading...");
            	}
            	
            }
        }
		return true;
	}
	
	public void onSyncCompleted(){
		progress.dismiss();
		activity.startActivity(new Intent(activity,ChannelListActivity.class));
	}
}
