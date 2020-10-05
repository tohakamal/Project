package com.example.customcalendarview.transaction;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customcalendarview.R;

import java.util.ArrayList;

public class AdapterRecord extends RecyclerView.Adapter<AdapterRecord.HolderRecord> {

    private Context context;
    private ArrayList<ModelRecord> recordsList;

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_record, parent,false);
        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {

        ModelRecord model = recordsList.get(position);
        String id = model.getId();
        String name = model.getAccountName();
        String amount = model.getAmount();
        String image = model.getImage();
        String date = model.getDate();
        String details = model.getDetails();
        String addedTime = model.getAddedTime();
        String updatedTime = model.getUpdatedTime();


        holder.accountName.setText(name);
        holder.amount.setText(amount);
        holder.date.setText(date);
        holder.details.setText(details);
        holder.profileIv.setImageURI(Uri.parse(image));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    class HolderRecord extends RecyclerView.ViewHolder{

        ImageView profileIv;
        TextView accountName,amount,date,details;
        ImageButton moreBtn;

        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            profileIv = itemView.findViewById(R.id.profileIv);
            accountName = itemView.findViewById(R.id.nameTv);
            amount = itemView.findViewById(R.id.amountTv);
            date = itemView.findViewById(R.id.dateTv);
            details = itemView.findViewById(R.id.detailsTv);
            moreBtn = itemView.findViewById(R.id.moreBtn);
        }
    }
}
