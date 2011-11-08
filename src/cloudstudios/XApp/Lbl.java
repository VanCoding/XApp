package cloudstudios.XApp;

import android.content.Context;
import android.widget.TextView;

public class Lbl extends TextView{
	private int w = -2;
	private int h = -2;
	
	public Lbl(Context context) {
		super(context);
	}
	public Lbl width(int w){
		this.w = w;
		return this;
	}
	public Lbl height(int h){
		this.h = h;
		return this;
	}
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
