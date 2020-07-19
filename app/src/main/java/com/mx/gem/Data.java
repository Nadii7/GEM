package com.mx.gem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.mx.gem.adapters.DataAdapter;
import com.mx.gem.models.Cat;
import com.mx.gem.models.Catitem;

import java.util.ArrayList;
import java.util.List;

public class Data extends AppCompatActivity {
    private ImageView CategoryCoverImg;
    private ImageButton button;
    private TextView tv_title;
    private List<Catitem> lstdataItems;
    private RecyclerView DataRV ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catitems);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String catTitle = getIntent().getExtras().getString("cat_title");
        tv_title = findViewById(R.id.cat_title);
        tv_title.setText(catTitle);
        DataRV = findViewById(R.id.data_rec);
        lstdataItems = new ArrayList<>();

        switch (catTitle) {
            case "Kings":
                lstdataItems.add(new Catitem("Akhenaten", getString(R.string.k1), R.drawable.akhnatonp,R.drawable.akhnatonq));
                lstdataItems.add(new Catitem("Amenhotep", getString(R.string.k2), R.drawable.amenhotepp, R.drawable.amenhotepq));
                lstdataItems.add(new Catitem("Hatshepsut", getString(R.string.k3), R.drawable.hatshepsotp, R.drawable.hatshepsotq));
                lstdataItems.add(new Catitem("Nefertiti", getString(R.string.k4), R.drawable.nefertitip,R.drawable.nefertitiq));
                lstdataItems.add(new Catitem("Tutankhamun", getString(R.string.k5), R.drawable.tutankhamunp, R.drawable.tutankhamunq));
                break;
            case "Myths":
                lstdataItems.add(new Catitem("Anubis", getString(R.string.m1), R.drawable.anobisp,R.drawable.anubisq));
                lstdataItems.add(new Catitem("Jackal", getString(R.string.m2), R.drawable.jackalp,R.drawable.jackalq));
                lstdataItems.add(new Catitem("Osiris", getString(R.string.m3), R.drawable.osirisp,R.drawable.osirisq));
                lstdataItems.add(new Catitem("Sekhmet", getString(R.string.m4), R.drawable.sekmtp,R.drawable.sekhmtq));
                lstdataItems.add(new Catitem("Sphynx", getString(R.string.m5), R.drawable.sphynxp,R.drawable.sphynxq));
                break;
            case "Symbols":
                lstdataItems.add(new Catitem("Ancient Egyptian golden ark", getString(R.string.s1), R.drawable.ancientegyptiangoldenarkp,R.drawable.ancientegyptiangoldenarkq));
                lstdataItems.add(new Catitem("Ankh", getString(R.string.s2), R.drawable.ankhp,R.drawable.ankhq));
                lstdataItems.add(new Catitem("Ivory bracelet", getString(R.string.s3), R.drawable.ivorybraceletp,R.drawable.ivorybraceletq));
                lstdataItems.add(new Catitem("The Usekh or Wesekh", getString(R.string.s4), R.drawable.necklacep,R.drawable.necklaceq));
                lstdataItems.add(new Catitem("Tutankhamen's Painted Chest", getString(R.string.s5), R.drawable.paintedchestoftutankhamunp,R.drawable.paintedchestoftutankhamunq));
                break;
            case "Weapons":
                lstdataItems.add(new Catitem("Egypt weapon", getString(R.string.w1), R.drawable.egyptweaponp,R.drawable.egyptweaponq));
                lstdataItems.add(new Catitem("Khopesh sword", getString(R.string.w2), R.drawable.khopeshswordp,R.drawable.khopeshswordq));
                lstdataItems.add(new Catitem("Khopesh sword", getString(R.string.w3), R.drawable.repressedweaponp,R.drawable.repressedweaponq));
                lstdataItems.add(new Catitem("Scythe of Anubis", getString(R.string.w4), R.drawable.scytheofanubisp,R.drawable.scytheofanubisq));
                lstdataItems.add(new Catitem("Tutankhamun Iron Dagger", getString(R.string.w5), R.drawable.totankhamondaggerp,R.drawable.totankhamondaggerq));
                break;
        }

        DataAdapter dataAdapter = new DataAdapter(this, lstdataItems);
        DataRV.setAdapter(dataAdapter);
        DataRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        button=findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }


}
