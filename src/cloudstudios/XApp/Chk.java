package cloudstudios.XApp;

import android.content.Context;
import android.widget.CheckBox;

public class Chk extends CheckBox {

	public Chk(Context context) {
		super(context);

	}
	public Chk checked(boolean b){
		this.setChecked(b);
		return this;
	}
	
	public Chk change(OnCheckedChangeListener l){
		this.setOnCheckedChangeListener(l);
		return  this;
	}
}
