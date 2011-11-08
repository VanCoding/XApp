package cloudstudios.XApp;

import android.content.Context;
import android.widget.Button;

public class Btn extends Button {
	private int w = -2;
	private int h = -2;
	public Btn(Context c){
		super(c);
	}
	public Btn width(int w){
		this.w = w;
		return this;
	}
	public Btn height(int h){
		this.h = h;
		return this;
	}
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
