package com.myapplicationdev.android.p04_revisionnotes;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowList;
    EditText noteText;
    RadioGroup rg;
    Integer selectedRG;
    RadioButton rb;
    ArrayList<Note> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShowList = findViewById(R.id.buttonShowList);
        noteText = findViewById(R.id.editTextNote);
        rg = findViewById(R.id.radioGroupStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                selectedRG = rg.getCheckedRadioButtonId();
                rb = findViewById(selectedRG);
                if(rb.getText().equals("1")){
                    db.insertNote(noteText.getText().toString(),1);
                }else if(rb.getText().equals("2")){
                    db.insertNote(noteText.getText().toString(),2);
                }else if(rb.getText().equals("3")){
                    db.insertNote(noteText.getText().toString(),3);
                }else if(rb.getText().equals("4")){
                    db.insertNote(noteText.getText().toString(),4);
                }else{
                    db.insertNote(noteText.getText().toString(),5);
                }
                db.close();

            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                ArrayList<String> data = db.getNoteContent();

                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++){
                    txt += data.get(i) + " #" + i + "\n";
                }

                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("text",txt);
                startActivity(i);
            }
        });
    }
}
