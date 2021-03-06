package cloudstudios.XApp;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class Lbl extends TextView{
	private int w = -2;
	private int h = -2;
	
	public Lbl(Context context) {
		super(context);
	}
	public Lbl text(String text){
		this.setText(text);
		return this;
	}
	public Lbl width(int w){
		this.w = w;
		return this;
	}
	public Lbl height(int h){
		this.h = h;
		return this;
	}
	public Lbl textsize(int s){
		setTextSize(s);
		return this;
	}
	public Lbl bold(boolean b){
		this.setTypeface(null,b?Typeface.BOLD : Typeface.NORMAL);
		return this;
	}
	
	public Lbl padding(int p){
		this.setPadding(p,p,p,p);
		return this;
	}
	
	protected void onAttachedToWindow(){
		this.getLayoutParams().height = h;
		this.getLayoutParams().width = w;
	}
}
