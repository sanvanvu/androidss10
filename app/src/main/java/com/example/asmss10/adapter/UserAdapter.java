package com.example.asmss10.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asmss10.Getposi;
import com.example.asmss10.R;
import com.example.asmss10.UserEntity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<UserEntity> list;
    private Getposi getposi;

    public void setGetposi(Getposi getposi) {
        this.getposi = getposi;
    }

    public UserAdapter(Activity activity, List<UserEntity> list) {
        this.activity = activity;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder=activity.getLayoutInflater().inflate(R.layout.listuser_layout,parent,false);
        ViewHolderUser holderUser=new ViewHolderUser(viewHolder);
        return holderUser;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         UserEntity model=list.get(position);
     ViewHolderUser dataview= (ViewHolderUser) holder;
     dataview.tvUsername.setText(model.getName());
     dataview.tvGender.setText(model.getGender());
//
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolderUser extends RecyclerView.ViewHolder {
        TextView tvUsername,tvGender;
        public ViewHolderUser(@NonNull View itemView) {
            super(itemView);
            tvUsername=itemView.findViewById(R.id.tvUsername);
            tvGender=itemView.findViewById(R.id.tvGender);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getposi.IOnclick(getAdapterPosition());
                    Log.d("TAG", "onClick: "+getAdapterPosition());
                }
            });



        }
    }
}
