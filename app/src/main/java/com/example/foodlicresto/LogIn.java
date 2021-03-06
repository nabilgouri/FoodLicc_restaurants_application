package com.example.foodlicresto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodlicresto.Common.Common;
import com.example.foodlicresto.model.Restaurant;
import com.example.foodlicresto.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {
    EditText tel,password;
    Button log,reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        tel=(EditText)findViewById(R.id.tel);
        password=(EditText) findViewById(R.id.password);
        log=(Button)findViewById(R.id.log);



        final FirebaseDatabase db=FirebaseDatabase.getInstance();

        final DatabaseReference table_user=db.getReference("Restaurant");
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialogue=new ProgressDialog(LogIn.this);
                mDialogue.setMessage("Please wait....");
                mDialogue.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(tel.getText().toString()).exists()){
                            mDialogue.dismiss();

                            Restaurant u= dataSnapshot.child(tel.getText().toString()).getValue(Restaurant.class);
                            if(u.getPassword().equals(password.getText().toString())){
                                Toast.makeText(LogIn.this, "Connected !!", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(LogIn.this,Home.class);
                                Common.current_restaurant= u;
                                startActivity(intent);
                                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_in_left);
                                finish();
                            }
                            else {
                                Toast.makeText(LogIn.this, "Fucked!!", Toast.LENGTH_SHORT).show();



                            }
                        }
                        else {
                            mDialogue.dismiss();
                            Toast.makeText(LogIn.this, "User Not found sucker !!!!", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });




    }

}
