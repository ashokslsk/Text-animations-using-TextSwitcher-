package ash.textswitcher.trial;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class TextActivity extends Activity{

	 private TextSwitcher mSwitcher;
     Button btnNext;
    
     // Array of String to Show In TextSwitcher
     String textToShow[]={"Ashok is Awesome","Ashok is amazing","Lead Developer","True Engineer","People loves Him","He is Terrific andro-geek"};
     int messageCount=textToShow.length;
     // to keep current Index of text
     int currentIndex=-1;

    

     @Override
     protected void onCreate(Bundle savedInstanceState)
     {
                 super.onCreate(savedInstanceState);

               setContentView(R.layout.activity_text);                       
                
                 // get The references
                 btnNext=(Button)findViewById(R.id.buttonNext);
                 mSwitcher = (TextSwitcher) findViewById(R.id.textswitcher);
                
                 // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
                 mSwitcher.setFactory(new ViewFactory() {
                    
                     public View makeView() {
                         // create new textView and set the properties like color, size etc
                         TextView myText = new TextView(TextActivity.this);
                         myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                         myText.setTextSize(36);
                         myText.setTextColor(Color.BLUE);
                         return myText;
                     }
                 });

                 // Declare the in and out animations and initialize them 
                 Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
                 Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
                
                 // set the animation type of textSwitcher
                 mSwitcher.setInAnimation(in);
                 mSwitcher.setOutAnimation(out);
            
                 // ClickListener for NEXT button
                 // When clicked on Button TextSwitcher will switch between texts
                 // The current Text will go OUT and next text will come in with specified animation
                 btnNext.setOnClickListener(new View.OnClickListener() {
                    
                     public void onClick(View v) {
                         // TODO Auto-generated method stub
                         currentIndex++;
                         // If index reaches maximum reset it
                         if(currentIndex==messageCount)
                             currentIndex=0;
                         mSwitcher.setText(textToShow[currentIndex]);
                     }
                 });
      
     }
}
