package cloudstudios.XApp;

import android.os.Bundle;
import cloudstudios.XClient.Client;

public class ProgramListActivity extends ViewActivity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Client client = ConnectActivity.client;
        
        Lin view;
        setContentView(
        	Vs(
        		view = Lin().vertical(true)
        	)
        );        
        
        for(int i = 0; i < client.getProgramCount(); i++){
        	view.addView(new ProgramListEntry(getApplicationContext(),this,i,client.getProgram(i)));
    		view.addView(Lin().height(1).width(-1).color(0xff333333));
        }
    }
}
