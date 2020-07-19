package com.mx.gem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mx.gem.adapters.CategoryAdapter;
import com.mx.gem.models.Cat;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity{

    private List<Cat> lstCats;
    private RecyclerView CategoryRV ;
    private de.hdodenhof.circleimageview.CircleImageView user_pic , qrbut ,facebut;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    String mUID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        CategoryRV = findViewById(R.id.Cat_Rv);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        user_pic = findViewById(R.id.user_pic);
        qrbut = findViewById(R.id.qr_but);
        facebut = findViewById(R.id.face_but);
        try {
            Glide.with(this).load(currentUser.getPhotoUrl()).into(user_pic);
        }catch (Exception e){
            e.printStackTrace();
        }
        user_pic.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
                finish();
                return true;
            }
        });

        /*  qrbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent qrIntent = new Intent(getApplicationContext(),QrActivity.class);
                startActivity(qrIntent);
            }
        });
        facebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faceIntent = new Intent(getApplicationContext(),QrActivity.class);
                startActivity(faceIntent);
            }
        });*/
        // Recyclerview Setup
        // ini data

        lstCats = new ArrayList<>();
        lstCats.add(new Cat("Kings",R.drawable.akhnatonp,R.drawable.nefertitip,R.drawable.tutankhamunp,R.drawable.amenhotepp));
        lstCats.add(new Cat("Myths",R.drawable.anobisp,R.drawable.jackalp,R.drawable.osirisp,R.drawable.sphynxp));
        lstCats.add(new Cat("Symbols",R.drawable.necklacep,R.drawable.ankhp,R.drawable.ivorybraceletp,R.drawable.ancientegyptiangoldenarkp));
        lstCats.add(new Cat("Weapons",R.drawable.totankhamondaggerp,R.drawable.scytheofanubisp,R.drawable.repressedweaponp,R.drawable.egyptweaponp));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this, lstCats);
        CategoryRV.setAdapter(categoryAdapter);
        CategoryRV.setLayoutManager(new GridLayoutManager(this,2));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
