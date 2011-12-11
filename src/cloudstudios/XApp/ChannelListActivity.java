package cloudstudios.XApp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import cloudstudios.XClient.Channel;
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
        try{
	        Channel[] in = client.getInputChannels();
	        Channel[] out = client.getOutputChannels();
	        for(int i = 0; i < in.length; i++){
	        	if(in[i] != null){
		        	view.addView(new ChannelListEntry(getApplicationContext(),this,in[i]));
		    		view.addView(Lin().height(1).width(-1).color(0xff333333));
	        	}
	        }
	        for(int i = 0; i < out.length; i++){
	        	Log.d("abc","get"+i+"");
	        	if(out[i] != null){
		        	view.addView(new ChannelListEntry(getApplicationContext(),this,out[i]));
		    		view.addView(Lin().height(1).width(-1).color(0xff333333));
		        }else{
		        	Log.d("abc",i+" is null");
		        }
	        }
        }catch(Exception e){
        	//Log.d("abc",e.getMessage());
        }
    }
	public boolean onCreateOptionsMenu(Menu m){
		m.add("Save");
		m.add("Load");
		m.add("Disconnect");
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem i){
		if(i.getTitle().equals("Disconnect")){
			ConnectActivity.client.disconnect();
			this.startActivity(new Intent(this,ConnectActivity.class));
		}else{
			Intent in = new Intent(this,ProgramListActivity.class); 
			in.putExtra("mode", i.getTitle());
			this.startActivity(in);
		}
		return true;
	}
}
