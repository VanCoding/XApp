package cloudstudios.XApp;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ViewActivity extends Activity {
	public LinearLayout Hl(View... views){
    	LinearLayout l = new LinearLayout(getApplicationContext());    	
    	for(int i = 0; i < views.length; i++){
    		l.addView(views[i]);
    	}
    	return l;
    }
	public LinearLayout Vl(View... views){
		LinearLayout l = new LinearLayout(getApplicationContext());
		l.setOrientation(LinearLayout.VERTICAL);
		for(int i = 0; i < views.length; i++){
			l.addView(views[i]);
		}
		return l;	
	}
	public HorizontalScrollView Hs(View... views){
		LinearLayout l = Hl();
    	for(int i = 0; i < views.length; i++){
    		l.addView(views[i]);
    	}
    	HorizontalScrollView s = new HorizontalScrollView(getApplicationContext());    	
    	s.addView(l);
    	return s;
	}
	public ScrollView Vs(View... views){
		LinearLayout l = Vl();
    	for(int i = 0; i < views.length; i++){
    		l.addView(views[i]);
    	}
    	ScrollView s = new ScrollView(getApplicationContext());
    	s.addView(l);
    	return s;
	}
    public TextView Lbl(String text){
    	TextView t = new TextView(getApplicationContext());
    	t.setText(text);
    	return t;
    }
    public EditText Txt(String text){
    	EditText t = new EditText(getApplicationContext());
    	t.setText(text);
    	return t;
    }
    public Button Btn(String text){
    	Button b = new Button(getApplicationContext());
    	b.setText(text);
    	return b;
    }
}