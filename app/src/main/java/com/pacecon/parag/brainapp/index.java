package com.pacecon.parag.brainapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class index extends AppCompatActivity {
    ImageButton btn_learn,btn_puzzle;
    MediaPlayer mp1,mp2;
   // FrameLayout frmla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        index si = new index();
        si.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final String s= getIntent().getStringExtra("caller");
        View imgview = findViewById(R.id.imageView);
       /* if (s.equals("1")){
                    Toast tt = Toast.makeText(this,"ONE",Toast.LENGTH_SHORT);
                    tt.show();

            imgview.setBackgroundResource((R.drawable.bg1));
           // frmla = new FrameLayout(this);
          // View frmla = (FrameLayout) findViewById(R.layout.activity_index);
            //frmla.setBackgroundResource(R.drawable.bg2);//="@drawable/colorbg";
            //setContentView(frmla);
          // layout.activity_index.setBackground(ContextCompat.getDrawable(index.this, R.drawable.bg1));
           // setContentView(R.layout.activity_index);
                    }
        if (s.equals("2")){ Toast tt = Toast.makeText(this,"TWO",Toast.LENGTH_SHORT);
            tt.show();

            imgview.setBackgroundResource((R.drawable.bg2));
         //   frmla = new FrameLayout(this);
          //  frmla.setBackgroundResource(R.drawable.bg2);
           // setContentView(frmla);
            }*/
        if (s.equals("1")){imgview.setBackgroundResource((R.drawable.bg1));}
        if (s.equals("2")){imgview.setBackgroundResource((R.drawable.bg2));}
        if (s.equals("3")){imgview.setBackgroundResource((R.drawable.bg3));}
        if (s.equals("4")){imgview.setBackgroundResource((R.drawable.bg4));}
        if (s.equals("5")){imgview.setBackgroundResource((R.drawable.bg5));}
        if (s.equals("6")){imgview.setBackgroundResource((R.drawable.bg6));}
        if (s.equals("7")){imgview.setBackgroundResource((R.drawable.bg7));}
        if (s.equals("8")){imgview.setBackgroundResource((R.drawable.bg8));}

        btn_learn = (ImageButton)findViewById(R.id.btn_learn);
        btn_learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1 = MediaPlayer.create(index.this, R.raw.md);
                mp1.start();
                Intent i=new Intent(index.this,learn.class);
                i.putExtra("caller",s);
                startActivity(i);
            }
        });
        btn_puzzle = (ImageButton)findViewById(R.id.btn_puzzle);
        btn_puzzle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1 = MediaPlayer.create(index.this, R.raw.md);
                mp1.start();
                Intent i=new Intent(index.this,puzzlea.class);
                i.putExtra("caller",s);
                startActivity(i);
            }
        });
    }
}
