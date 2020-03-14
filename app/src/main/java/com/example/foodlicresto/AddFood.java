package com.example.foodlicresto;

import android.app.ProgressDialog;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodlicresto.Common.Common;
import com.example.foodlicresto.model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFood extends AppCompatActivity {
    EditText e1,e2,e3;
    Button add,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        e1=(EditText)findViewById(R.id.namefood);
        e2=(EditText)findViewById(R.id.decfood);
        e3=(EditText)findViewById(R.id.pricefood);
        add=(Button)findViewById(R.id.epbtnupdate);
        cancel=(Button)findViewById(R.id.epbtncancel);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference table_food = firebaseDatabase.getReference("Food");
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                table_food.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String id=String.valueOf(System.currentTimeMillis());
                        String dic="";
                        Food food = new Food(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),Common.current_restaurant.getId());

                        table_food.child(e1.getText().toString()+" "+Common.current_restaurant.getId()).setValue(food);
                        Toast.makeText(AddFood.this, "Food Added", Toast.LENGTH_SHORT).show();
                        finish();



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();

            }
        });


















    }
    void cancel(){

        e1.setText("");
        e2.setText("");
        e3.setText("");
    }
}
