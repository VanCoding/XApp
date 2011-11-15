package cloudstudios.XApp;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public class Lin extends LinearLayout {
	
	private int w = -1;
	private int h = -1;

	public Lin(Context context) {
		super(context);
	}
	public Lin(Context context, View... views){
		this(context);
		for(int i = 0; i < views.length; i++){
			this.addView(views[i]);
		}
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
	public Lin touch(OnTouchListener l){
		this.setOnTouchListener(l);
		return this;
	}
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
