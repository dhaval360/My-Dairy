package com.example.mydairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        EditText userName = (EditText)  findViewById(R.id.userName);
        EditText password = (EditText)  findViewById(R.id.password);
        if(userName.getText().toString().equals("Dhaval") && password.getText().toString().equals("Kathad")){
            Intent intent = new Intent(this, main.class);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this,"Invalide login",Toast.LENGTH_LONG);
            toast.show();
        }
    }


}
