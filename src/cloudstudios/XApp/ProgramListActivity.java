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
        
        String[] programs = client.getPrograms();
        for(int i = 0; i < programs.length; i++){
        	view.addView(new ProgramListEntry(getApplicationContext(),this,i,programs[i]));
    		view.addView(Lin().height(1).width(-1).color(0xff333333));
        }
    }
}
