package cloudstudios.XApp;

import cloudstudios.XClient.*;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ConnectActivity extends ViewActivity implements OnClickListener, ClientEventReceiver {
    public static Client client;
    private Txt ip;
    private Btn connect;
    private ProgressDialog progress;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(Vs(
        	Lin(
        		Lbl("IP:").width(100),
        		ip = Txt("192.168.1.85").width(-1)
        	),
        	Lin(
        		connect = Btn("Connect").width(200)
        	).gravity(5)
        ));
        connect.setOnClickListener(this);
        
    }
    public void OnConnect(){
    	progress.dismiss();
    	Log.d("abc", "CONNECTED!!!");
    	this.startActivity(new Intent(this,ChannelListActivity.class));    	
    }
    public void OnError(String error){
    	Log.d("abc","ERROR:"+error);
    	progress.dismiss();
    }
	
    public void onClick(View v){
    	client = new Client(ip.getText().toString(),0);
    	client.setEventReceiver(this);
    	client.connectAsync();
    	progress = ProgressDialog.show(ConnectActivity.this, "Connecting...","Connecting...");
	}
}