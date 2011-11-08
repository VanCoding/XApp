package cloudstudios.XApp;

import android.content.Context;
import android.widget.EditText;

public class Txt extends EditText {
	private int w = -2;
	private int h = -2;

	
	public Txt(Context context) {
		super(context);
	}
	public Txt width(int w){
		this.w = w;
		return this;
	}
	public Txt height(int h){
		this.h = h;
		return this;
	}
	
	public Txt textsize(int s){
		this.setTextSize(s);
		return this;
	}
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
