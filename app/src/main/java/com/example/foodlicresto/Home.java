package com.example.foodlicresto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodlicresto.Common.Common;

public class Home extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CardView cardView1,cardView2,cardView3,cardView4;
        TextView textView;
        cardView1=(CardView)findViewById(R.id.order);
        cardView2=(CardView)findViewById(R.id.menu);
        cardView3=(CardView)findViewById(R.id.addfood);
        cardView4=(CardView)findViewById(R.id.editprofile);
        textView=(TextView)findViewById(R.id.restoname);
        textView.setText(Common.current_restaurant.getName()+" restaurant");

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Menu.class);
                startActivity(intent);

            }
        });










        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Orders.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,AddFood.class);
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,EditProfile.class);
                startActivity(intent);
            }
        });



    }




}
