package com.example.asmss10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    TextView edName,edDescription;
    TextView tvGender;
    Appdatabase db;
    Button btEdit,btDelete;

    private static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        edName=findViewById(R.id.tvName);
        edDescription=findViewById(R.id.tvDescription);
        btEdit=findViewById(R.id.btEdit);
        btDelete=findViewById(R.id.btDelete);


        tvGender=findViewById(R.id.tvgender);
        Intent intent=getIntent();
      String i=  intent.getStringExtra("NAME");
       db=Appdatabase.getAppDatabase(this);
      UserEntity user=db.userDao().findByName(i);
      edName.setText(user.getName());
      edDescription.setText(user.getDescription());
      tvGender.setText(user.getGender());
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(user!=null){
//                   UserModel userModel=new UserModel(user.getId(),user.getName(),user.getDescription(),user.getGender());
                   Intent intent=new Intent(DetailActivity.this,EditActivity.class);
                   intent.putExtra("name", (Parcelable) user);
                   startActivityForResult(intent,REQUEST_CODE);
               }
               if(user==null){
                   Toast.makeText(DetailActivity.this,"null",Toast.LENGTH_LONG).show();
               }
            }
        });
//        String[] genders= {"Male","Female","Unknow"};
//        spinner=findViewById(R.id.spGender);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,genders);
//        spinner.setAdapter(adapter);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
              UserEntity  user=  data.getParcelableExtra("RESULT");

                edName.setText(user.getName());
                edDescription.setText(user.getDescription());
                tvGender.setText(user.getGender());
            }
        }
    }

}