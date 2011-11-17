package cloudstudios.XApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import cloudstudios.XClient.Client;

public class ChannelListActivity extends ViewActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Client client = ConnectActivity.client;
        
        Lin view;
        setContentView(
        	Vs(
        		view = Lin().vertical(true)
        	)
        );        

        for(int i = 0; i < client.getChannelCount(); i++){
        	view.addView(new ChannelListEntry(getApplicationContext(),this,client.getChannel(i)));
    		view.addView(Lin().height(1).width(-1).color(0xff333333));
        }   
    }
	public boolean onCreateOptionsMenu(Menu m){
		m.add("Save");
		m.add("Load");
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem i){
		Intent in = new Intent(this,ProgramListActivity.class); 
		in.putExtra("mode", i.getTitle());
		this.startActivity(in);
		return true;
	}
}
