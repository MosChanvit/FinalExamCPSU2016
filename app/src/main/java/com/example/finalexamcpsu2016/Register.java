package com.example.finalexamcpsu2016;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexamcpsu2016.DB.DatabaseHelper;

public class Register extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText edt_name=(EditText) findViewById(R.id.edt_name);
        EditText edt_username=(EditText) findViewById(R.id.edt_username);
        EditText edt_password=(EditText) findViewById(R.id.edt_password);
        Button buttonregister =(Button) findViewById(R.id.bt_register);

        final String name= edt_name.getText().toString();
        final String username = edt_username.getText().toString();
        final String passworld= edt_password.getText().toString();




        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.AddTotalscore(name,username,passworld);
                Intent intent = new Intent(Register.this, MainActivity.class);
                intent.putExtra("nsme",name);
                intent.putExtra("username",username);
                intent.putExtra("passworld",passworld);
                intent.putExtra("status", "1");
                startActivity(intent);
            }
        });






    }
}
