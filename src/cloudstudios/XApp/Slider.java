package cloudstudios.XApp;

import android.content.Context;
import android.widget.SeekBar;

public class Slider extends SeekBar {

	public Slider(Context context) {
		super(context);
	}
	
	private int w = -1;
	private int h = -2;

	public Slider width(int w){
		this.w = w;
		return this;
	}
	public Slider height(int h){
		this.h = h;
		return this;
	}
	
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
