package com.example.customcalendarview.Bank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendarview.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

   private Context context;
   private ArrayList name,amount;

    CustomAdapter(Context context,
                  ArrayList name,
                  ArrayList amount){

        this.context = context;
        this.name = name;
        this.amount = amount;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(String.valueOf(name.get(position)));
        holder.amount.setText(String.valueOf(amount.get(position)));
    }

    @Override
    public int getItemCount()
    {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nametexview);
            amount = itemView.findViewById(R.id.amounttextView);
        }
    }
}
