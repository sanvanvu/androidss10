package com.example.asmss10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView edName,edDescription;
    TextView tvGender;
    Appdatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        edName=findViewById(R.id.tvName);
        edDescription=findViewById(R.id.tvDescription);

        tvGender=findViewById(R.id.tvgender);
        Intent intent=getIntent();
      String i=  intent.getStringExtra("NAME");
       db=Appdatabase.getAppDatabase(this);
      UserEntity user=db.userDao().findByName(i);
      edName.setText(user.getName());
      edDescription.setText(user.getDescription());
      tvGender.setText(user.getGender());
//        String[] genders= {"Male","Female","Unknow"};
//        spinner=findViewById(R.id.spGender);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,genders);
//        spinner.setAdapter(adapter);



    }

}