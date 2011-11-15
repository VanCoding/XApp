package cloudstudios.XApp;

import android.app.Activity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

public class ViewActivity extends Activity {
	
	public Lin Lin(View ... views){
		Lin l = new Lin(getApplicationContext());
		for(int i = 0; i < views.length; i++){
    		l.addView(views[i]);
    	}
		return l;
	}
	public HorizontalScrollView Hs(View... views){
		Lin l = Lin(views);
    	HorizontalScrollView s = new HorizontalScrollView(getApplicationContext());    	
    	s.addView(l);
    	return s;
	}
	public ScrollView Vs(View... views){
		Lin l = Lin(views).vertical(true);

    	ScrollView s = new ScrollView(getApplicationContext());
    	s.addView(l);
    	return s;
	}
    public Lbl Lbl(String text){
    	Lbl t = new Lbl(getApplicationContext());
    	t.setText(text);
    	return t;
    }
    public Txt Txt(String text){
    	Txt t = new Txt(getApplicationContext());
    	t.setText(text);
    	return t;
    }
    public Btn Btn(String text){
    	Btn b = new Btn(getApplicationContext());
    	b.setText(text);
    	return b;
    }
    public Chk Chk(){
    	return new Chk(getApplicationContext());
    }
    public Slider Slider(){
    	return new Slider(getApplicationContext());
    }
}