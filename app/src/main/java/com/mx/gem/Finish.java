package com.mx.gem;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class Finish extends AppCompatActivity {
private ImageView item_image,item_qr;
private TextView item_title , item_description ;
private ImageButton back , play,pause,stop;
MediaPlayer player;
int song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String Title = getIntent().getExtras().getString("name");
        String description = getIntent().getExtras().getString("des");
        int img = getIntent().getExtras().getInt("pic");
        int qr = getIntent().getExtras().getInt("qr");
        item_image = findViewById(R.id.item_img);
        Glide.with(this).load(img).into(item_image);
        item_qr = findViewById(R.id.item_qr);
        Glide.with(this).load(qr).into(item_qr);
        item_title = findViewById(R.id.data_title);
        item_title.setText(Title);
        item_description = findViewById(R.id.item_description);
        item_description.setText(description);
        item_description.setMovementMethod(new ScrollingMovementMethod());

        back=findViewById(R.id.back);
        play=findViewById(R.id.play_but);
        pause=findViewById(R.id.pause_but);
        stop=findViewById(R.id.stop_but);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });

        if ("Akhenaten".equals(Title)) {
            song = R.raw.akhnaten;
        } else if ("Ankh".equals(Title)) {
            song = R.raw.ankh_ar;
        } else if ("Amenhotep".equals(Title)) {
            song = R.raw.anotophise_ar;
        } else if ("Sphynx".equals(Title)) {
            song = R.raw.sphenxcat;
        }else{
            song = 0;
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });


    }


    private void play() {
        if (song!=0) {
            if (player == null) {
                player = MediaPlayer.create(this, song);
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopPlayer();
                    }
                });
            }
            player.start();
        }else{
            Toast.makeText(getApplicationContext(),"There is no audio for this item",Toast.LENGTH_SHORT).show();
        }
    }

    private void pause() {
        if (player!=null)
            player.pause();
    }

    private void stop() {
        stopPlayer();
    }

    private void stopPlayer() {
        if (player!=null){
            player.release();
            player= null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    void iniViews() {
        }
}
