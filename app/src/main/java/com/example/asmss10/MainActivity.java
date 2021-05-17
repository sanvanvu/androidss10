package com.example.asmss10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.asmss10.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Getposi{

    Appdatabase db;
    RecyclerView recyclerView;
    UserAdapter adapter;
    List<UserEntity> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=Appdatabase.getAppDatabase(this);
        recyclerView=findViewById(R.id.rvMain);
        getAll();

        adapter=new UserAdapter(this,list);
        adapter.setGetposi(this);


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public  void  getAll(){
        if(db.userDao().getUser()!=null){
            list=db.userDao().getUser();
        }

    }

    @Override
    public void IOnclick(int position) {
        UserEntity user=list.get(position);
        Intent intent =new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("NAME",user.getName());
        startActivity(intent);
    }
}