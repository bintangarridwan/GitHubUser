package com.bintangr.githubuserapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bintangr.githubuserapp.R;
import com.bintangr.githubuserapp.model.userModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.myHolder> {
    Context context;
    ArrayList<userModel> userlist = new ArrayList<>();

    public userAdapter(Context context) {
        this.context = context;
    }

    public void setUser(ArrayList<userModel> userlist){
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_list, parent, false);
        return new  myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
        holder.textUsername.setText(userlist.get(position).getUsername());
        holder.textName.setText(userlist.get(position).getName());
        holder.imageView.setImageResource(userlist.get(position).getAvatar());
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        TextView textUsername, textName;
        ImageView imageView;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            textUsername = itemView.findViewById(R.id.text_username);
            textName = itemView.findViewById(R.id.text_name);
            imageView = itemView.findViewById(R.id.main_image);
        }
    }
}
