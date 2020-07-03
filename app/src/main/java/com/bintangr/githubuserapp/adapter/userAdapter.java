package com.bintangr.githubuserapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bintangr.githubuserapp.DetailActivity;
import com.bintangr.githubuserapp.R;
import com.bintangr.githubuserapp.model.userModel;

import java.util.ArrayList;
import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.myHolder> implements Filterable {
    Context context;
    ArrayList<userModel> userlist = new ArrayList<>();
    ArrayList<userModel> userFull;

    public userAdapter(Context context) {
        this.context = context;
    }

    public void setUser(ArrayList<userModel> userlist){
        this.userlist = userlist;
        this.userFull = new ArrayList<>(userlist);
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_list, parent, false);
        return new  myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, final int position) {
        holder.textUsername.setText(userlist.get(position).getUsername());
        holder.textName.setText(userlist.get(position).getName());
        holder.imageView.setImageResource(userlist.get(position).getAvatar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent(context, DetailActivity.class);
                send.putExtra("username", userlist.get(position));
                send.putExtra("repo", userlist.get(position));
                view.getContext().startActivity(send);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    @Override
    public Filter getFilter() {
        return filters;
    }
    private Filter filters = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<userModel> filterList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0){
                filterList.addAll(userFull);
            } else {
                String filterPatern = charSequence.toString().toLowerCase().trim();
                for (userModel item : userFull){
                    if (item.getUsername().toLowerCase().contains(filterPatern) || item.getName().toLowerCase().contains(filterPatern)){
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        userlist.clear();
        userlist.addAll((List)filterResults.values);
        notifyDataSetChanged();
        }
    };

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
