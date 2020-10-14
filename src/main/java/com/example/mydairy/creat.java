package com.example.mydairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class creat extends AppCompatActivity {


    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);

        input = (EditText) findViewById(R.id.input);
    }

    public void done(View view){
        String in = input.getText().toString();

        String date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        notesDataObject note = new notesDataObject(date, in);
        DataBaseHelper db = new DataBaseHelper(this);
        boolean status = db.addNote(note);
        if(status){
            Toast.makeText(this, "User Note Saved", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Some problem occure", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this , main.class);
        startActivity(intent);
    }

}
