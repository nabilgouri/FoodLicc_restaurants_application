package com.example.foodlicresto;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.resources.MaterialResources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.foodlicresto.Common.Common;
import com.example.foodlicresto.model.Request;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Orders extends AppCompatActivity {
    ArrayList<Request> list;
RecyclerView recyclerView;
MyAdapter adapter;
    public RadioGroup orderStatus;
    DatabaseReference request;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        LoadOrders();


    }
    private void LoadOrders(){

        final DatabaseReference table_restaurant;
        Query q1=FirebaseDatabase.getInstance().getReference("Request").orderByChild("restoID").equalTo(Common.current_restaurant.getId());

        q1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Request>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Request p = dataSnapshot1.getValue(Request.class);
                    list.add(p);
                }
                adapter = new MyAdapter(Orders.this,list);
                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Orders.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
