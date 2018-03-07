package dscheriau.palindrome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button btnCheck = null;
    EditText etInput = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_palindrome);

        //init Widgets
        btnCheck = (Button) findViewById(R.id.btnCheck);
        etInput = (EditText) findViewById(R.id.etInput);

        //Set on click listener which listen to click actions
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = etInput.getText().toString();
                String msg = "";

                if(!word.equals("")){
                    if(!(word.length()<5)){
                        if( isPalindrome(word) ){
                            //word is a palindrome

                        }else{
                            //word isn't a palindrome
                        }
                    }else{
                        //word is to short
                    }
                }else{
                    //pls enter a word
                }
            }
        });
    }

    public boolean isPalindrome(String word){
        return word.equals(new StringBuilder(word).reverse().toString());
    }

}
