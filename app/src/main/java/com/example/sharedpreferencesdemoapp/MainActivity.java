package com.example.sharedpreferencesdemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declares the views
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);

        //Making shared preferences to display when app opens.
        SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        String editVal = sp.getString("name","No value as now stored in it");
        textView.setText(editVal);

        //Putting set on clicklistener in the button if anyone press then it saves the name.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Converting the editText to String .
                String val = editText.getText().toString();
                //Make a SharedPreferences DataStorage in phone memory.
                SharedPreferences sp = getSharedPreferences("MyPref",MODE_PRIVATE);
                //use a editer to edit them .
                SharedPreferences.Editor ed = sp.edit();
                //use putString to store the data in the storage when anyone press button.
                ed.putString("name",val);
                //use apply to save the data .
                ed.apply();
                textView.setText(val);
            }
        });
    }
}