package cloudstudios.XApp;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class Slider extends SeekBar {

	public Slider(Context context) {
		super(context);
	}
	
	private int w = -1;
	private int h = -2;
	private float p = 1f;

	public Slider width(int w){
		this.w = w;
		return this;
	}
	public Slider width(double w){
		width(-1);
		p = (float)w;
		return this;
	}
	public Slider height(int h){
		this.h = h;
		return this;
	}
	public Slider height(double h){
		height(-1);
		p = (float)h;
		return this;
	}
	public Slider seeked(OnSeekBarChangeListener l){
		this.setOnSeekBarChangeListener(l);
		return this;
	}
	public Slider max(int m){
		this.setMax(m);
		return this;
	}
	public Slider progress(int p){
		this.setProgress(p);
		return this;
	}
	protected void onAttachedToWindow(){
		setLayoutParams(new LinearLayout.LayoutParams(w, h, p));
	}
}
