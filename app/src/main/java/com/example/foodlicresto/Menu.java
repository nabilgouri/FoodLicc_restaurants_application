package com.example.foodlicresto;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.foodlicresto.Common.Common;
import com.example.foodlicresto.model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Food>list2;
    FragAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView=(RecyclerView)findViewById(R.id.rec3);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);




        Query q1= FirebaseDatabase.getInstance().getReference("Food").orderByChild("menuid").equalTo(Common.current_restaurant.getId());


        q1.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                list2 = new ArrayList<Food>();


                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Food p = dataSnapshot1.getValue(Food.class);
                    list2.add(p);

                }
                adapter = new FragAdapter(Menu.this,list2);
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }
}
