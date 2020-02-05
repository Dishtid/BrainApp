package com.pacecon.parag.brainapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class puzzlea extends AppCompatActivity {
    ImageButton bt_pre,bt_nex,bt_fwd,bt_rev,bt_hom;
    MediaPlayer mp1;
    ImageView imgview,imgviewa,imgviewb, imgview3,imgbee;
    int counter=1;
    int decdigit = 0;
    TextView tv;
    private int _xDelta;
    private int _yDelta;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzlea);
        imgview = (ImageView) findViewById(R.id.imgview);
        imgviewa = (ImageView) findViewById(R.id.imgviewa);

        imgviewb = (ImageView) findViewById(R.id.imgviewb);
        imgview3 = (ImageView ) findViewById(R.id.imageView3);
        imgbee = (ImageView ) findViewById(R.id.imgbee);
        tv = (TextView) findViewById(R.id.textView);
        // imgview.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        //  imgview.playSoundEffect(SoundEffectConstants.CLICK);

        // Assign the touch listener to your view which you want to move
        findViewById(R.id.imgbee).setOnTouchListener(new puzzlea.MyTouchListener1());
        // findViewById(R.id.activity_learn).setOnDragListener(new MyDragListener());

        s= getIntent().getStringExtra("caller");
        if (s.equals("1")){imgview3.setBackgroundResource(R.drawable.lbgcolors);}
        if (s.equals("2")){imgview3.setBackgroundResource((R.drawable.lbgshapes));}
        if (s.equals("3")){imgview3.setBackgroundResource((R.drawable.lbgnumbers));}
        if (s.equals("4")){imgview3.setBackgroundResource((R.drawable.lbgalpha));}
        if (s.equals("5")){imgview3.setBackgroundResource((R.drawable.lbganimal));}
        if (s.equals("6")){imgview3.setBackgroundResource((R.drawable.lbgveg));}
        if (s.equals("7")){imgview3.setBackgroundResource((R.drawable.lbgfruit));}
        if (s.equals("8")){imgview3.setBackgroundResource((R.drawable.lbgfruit));}
        checkfunction(1);
        bt_pre = (ImageButton) findViewById(R.id.btn_prev);
        bt_nex = (ImageButton) findViewById(R.id.btn_next);
        bt_fwd = (ImageButton) findViewById(R.id.btn_forward);
        bt_rev = (ImageButton) findViewById(R.id.btn_rewind);
        bt_hom = (ImageButton) findViewById(R.id.btn_home);

        imgview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp1.start();
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_animation);
                imgview.startAnimation(animation);
                imgbee.setImageResource(R.drawable.beehappy);
            }
        });
        imgviewa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp1.start();
                imgviewa.setVisibility(View.INVISIBLE);
                imgbee.setImageResource(R.drawable.beesad);
            }
        });
        imgviewb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp1.start();
             //   Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in_animation);
                imgviewb.setVisibility(View.INVISIBLE);
                imgbee.setImageResource(R.drawable.beesad);

            }
        });

        bt_hom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(puzzlea.this,menu.class);
                startActivity(i);
                //   bt_pre.playSoundEffect(SoundEffectConstants.CLICK);
            }
        });
        bt_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter>0) {counter =  counter -1;}
                checkfunction(1);
                //   bt_pre.playSoundEffect(SoundEffectConstants.CLICK);
            }
        });
        bt_nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter =  counter + 1;
                checkfunction(2);
                // v.playSoundEffect(SoundEffectConstants.CLICK);
            }
        });
        bt_fwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decdigit =  decdigit +1;
                counter=1;
                checkfunction(3);
                //   v.playSoundEffect(SoundEffectConstants.NAVIGATION_RIGHT);
            }
        });
        bt_rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decdigit>=1) {decdigit =  decdigit -1;}
                counter=1;
                checkfunction(4);
                // v.playSoundEffect(SoundEffectConstants.NAVIGATION_LEFT);
            }
        });
    }
    void checkfunction (int inputer) {
    tv.setText("Hello! Please find Apple");
        mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();
    }
    // This defines your touch listener
    private final class MyTouchListener1 implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
                /*if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                            view);
                    view.startDrag(data, shadowBuilder, view, 0);
                   view.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }*/
            int X = (int) motionEvent.getRawX();
            final int Y = (int) motionEvent.getRawY();
            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    //layoutParams.rightMargin = -250;
                    //layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams);
                    break;
            }

            return true;
        }
    }
}
