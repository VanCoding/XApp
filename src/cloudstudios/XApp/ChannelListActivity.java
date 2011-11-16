package cloudstudios.XApp;

import android.os.Bundle;
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
}
