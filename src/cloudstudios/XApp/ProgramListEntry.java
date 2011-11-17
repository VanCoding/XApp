package cloudstudios.XApp;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

public class ProgramListEntry extends Lin implements android.view.View.OnTouchListener  {

	private ProgramListActivity activity;
	private int program;

	public ProgramListEntry(Context context, ProgramListActivity activity, int program, String name) {
		super(context,
			new Lbl(activity.getApplicationContext()).text(program+": "+name).bold(true)
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
            	}else{
            		ConnectActivity.client.loadProgram(program);
            	}
            	activity.startActivity(new Intent(activity,ChannelListActivity.class));
            }
        }
		return true;
	}

}
