package cloudstudios.XApp;

import cloudstudios.XClient.Client;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ConnectActivity extends ViewActivity implements OnClickListener {
    public static Client client;
    private Txt ip;
    private Btn connect;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(Vs(
        	Lin(
        		Lbl("IP:").width(100),
        		ip = Txt("192.168.1.40").width(-1)
        	),
        	Lin(
        		connect = Btn("Connect").width(200)
        	).gravity(5)
        ));
        connect.setOnClickListener(this);
        
    }
    
    public void onClick(View v){
    	client = new Client(ip.getText().toString(),0);
		this.startActivity(new Intent(this,ControlActivity.class));
	}
}