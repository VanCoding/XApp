package cloudstudios.XApp;

import android.content.Context;
import android.widget.LinearLayout;

public class Lin extends LinearLayout {
	
	private int w = -1;
	private int h = -1;

	public Lin(Context context) {
		super(context);
	}
	public Lin width(int w){
		this.w = w;
		return this;
	}
	public Lin height(int h){
		this.h = h;
		return this;
	}
	public Lin vertical(boolean v){
		this.setOrientation(v?LinearLayout.VERTICAL:LinearLayout.HORIZONTAL);
		return this;
	}
	public Lin gravity(int g){
		setGravity(g);
		return this;
	}
	public Lin padding(int p){
		setPadding(p,p,p,p);
		return this;
	}
	public Lin color(int color){
		setBackgroundColor(color);
		return this;
	}
	
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
