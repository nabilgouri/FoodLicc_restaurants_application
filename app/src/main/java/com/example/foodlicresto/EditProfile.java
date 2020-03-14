package com.example.foodlicresto;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.foodlicresto.Common.Common;
import com.squareup.picasso.Picasso;

public class EditProfile extends AppCompatActivity {
    ImageView ivimage,coverpic;
    ImageButton ibgallery;
    Button btncancel;
    Button btnupdate;
    EditText etfname;
    EditText etlname;
    EditText etemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        ivimage = (ImageView) findViewById(R.id.epivimage);
        coverpic=(ImageView)findViewById(R.id.coverpic);
        ibgallery = (ImageButton) findViewById(R.id.epibgallery);
        btncancel = (Button) findViewById(R.id.epbtncancel);
        btnupdate = (Button) findViewById(R.id.epbtnupdate);

        etlname = (EditText) findViewById(R.id.epetlname);
        etlname.setText(Common.current_restaurant.getName());

        Picasso.get().load(Common.current_restaurant.getPropic()).into(ivimage);
        Picasso.get().load(Common.current_restaurant.getCoverpic()).into(coverpic);



    }
}
