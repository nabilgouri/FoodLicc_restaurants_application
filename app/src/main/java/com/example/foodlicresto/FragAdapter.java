package com.example.foodlicresto;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import com.example.foodlicresto.model.Food;
import com.example.foodlicresto.model.Order;

import java.util.ArrayList;

public class FragAdapter extends RecyclerView.Adapter<FragAdapter.MyViewHolder> {

    Context context;
    Button button;

    int i=0;

    public String getIsSelected() {
        return isSelected;
    }

    ArrayList<Food> profiles;
    String isSelected="";


    public FragAdapter(Context c , ArrayList<Food> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.menu_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.namefood.setText(profiles.get(position).getName());
        holder.description.setText(profiles.get(position).getDescription());
        holder.price.setText(profiles.get(position).getPrice());

        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(context, com.example.foodlic.Restaurant.class);

                //intent.putExtra("img",profiles.get(position).getCoverpic());
                //intent.putExtra("nomResto",profiles.get(position).getName());
                //context.startActivity(intent);

                isSelected ="true";




                i++;

                holder.qnt.setText(Integer.toString(i));
                holder.qnt.setVisibility(View.VISIBLE);












            }
        });
        i=0;


    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView namefood,description,price,qnt;
        LinearLayout parentlayout;

        Button btn;
        public MyViewHolder(View itemView) {
            super(itemView);
            namefood = (TextView) itemView.findViewById(R.id.foodname);

            description = (TextView) itemView.findViewById(R.id.fooddescroption);
           price=(TextView)itemView.findViewById(R.id.fooddprice);
           qnt=(TextView)itemView.findViewById(R.id.qnt);

           parentlayout=(LinearLayout)itemView.findViewById(R.id.layout);



        }
        public void onClick(final int position)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();


                }
            });
        }
    }
}

