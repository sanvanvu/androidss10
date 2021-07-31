package com.example.asmss10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

public class EditActivity extends AppCompatActivity {

    EditText edName,edDescription;
    TextView tvGender;
    Appdatabase db;
    Spinner spinner;
    Button btEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edName=findViewById(R.id.edName);
        edDescription=findViewById(R.id.edDescription);
        tvGender=findViewById(R.id.tvGender);
        btEnter=findViewById(R.id.btEnter);
        db=Appdatabase.getAppDatabase(this);
        String[] genders= {"Male","Female","Unknow"};
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
        initview();
        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editUser();



            }
        });

    }
    public void initview(){
        Intent intent=getIntent();
        UserEntity user= (UserEntity) intent.getParcelableExtra("name");
        edName.setText(user.getName());
        edDescription.setText(user.getDescription());
        tvGender.setText(user.getGender());


    }
    public void  editUser(){
        UserEntity userEntity=new UserEntity();
        userEntity.setName(edName.getText().toString());
        userEntity.setDescription(edDescription.getText().toString());
        userEntity.setGender(spinner.getSelectedItem().toString());
        db.userDao().updateUser(userEntity);
        Intent rtintent=new Intent();
        rtintent.putExtra("RESULT", (Parcelable) userEntity);
//   startActivity(intent);
        setResult(Activity.RESULT_OK,rtintent);
        finish();

    }
}