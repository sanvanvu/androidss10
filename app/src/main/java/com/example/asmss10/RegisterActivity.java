package com.example.asmss10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText edName,edDescripntion;
    Button btRegister;
    CheckBox ck;

    Spinner spinner;
    Appdatabase db;
    List<UserEntity> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=Appdatabase.getAppDatabase(this);
        edName=findViewById(R.id.etName);
        edDescripntion=findViewById(R.id.etDescription);
        btRegister=findViewById(R.id.btRegister);
        ck=findViewById(R.id.ck);
        String[] genders= {"Gripe","Gripe1","Gripe2"};
        spinner=findViewById(R.id.spGender);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,genders);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtRegister();
            }
        });

    }
    public  void  setBtRegister(){
        if(edName.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter Username",Toast.LENGTH_LONG).show();
            return;
        }
        if(edDescripntion.getText().toString().isEmpty()){
            Toast.makeText(this,"Please enter Description",Toast.LENGTH_LONG).show();
            return;
        }
        if(!ck.isChecked()){
            Toast.makeText(this,"Please agree rules",Toast.LENGTH_LONG).show();
            return;
        }

        UserEntity userEntity=new UserEntity();
        userEntity.setName(edName.getText().toString());
        userEntity.setDescription(edDescripntion.getText().toString());
        userEntity.setGender(spinner.getSelectedItem().toString());
        db.userDao().insertUser(userEntity);
        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
    }
}