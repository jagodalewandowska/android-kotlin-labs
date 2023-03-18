package utp.edu.mojapierwszaaplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RelativeLayout extends AppCompatActivity {
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openTableLayout();
            }
        });
        button2 = (Button) findViewById(R.id.button8);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openLinearLayout();
            }
        });
    }
    public void openTableLayout(){
        Intent intent = new Intent(this, TableLayout.class);
        startActivity(intent);
    }
    public void openLinearLayout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}