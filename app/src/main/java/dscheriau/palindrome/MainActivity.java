package dscheriau.palindrome;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
                String msg;
                String leer = " ";

                if(!word.equals(leer)){
                    if(!(word.length()<5)){
                        if( isPalindrome(word) ){
                            //word is a palindrome
                            msg= "Your word is a Palindrome!";
                        }else{
                            //word isn't a palindrome
                            msg = "Your word isn't a Palindrome!";
                        }
                    }else{
                        //word is to short
                       msg = "Your word is too short! ";
                    }
                }else{
                    //pls enter a word
                    msg = "Please enter a word !";
                }

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Result");
                dialogBuilder.setMessage(msg);
                dialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
            }
        });
    }

    public boolean isPalindrome(String word){
        return word.equals(new StringBuilder(word).reverse().toString());
    }

}
