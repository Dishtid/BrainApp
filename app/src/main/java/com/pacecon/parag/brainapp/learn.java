package com.pacecon.parag.brainapp;

import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import  android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import  android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.pacecon.parag.brainapp.R.id.textView;

public class learn extends AppCompatActivity {
    ImageButton bt_pre,bt_nex,bt_fwd,bt_rev,bt_hom;
    MediaPlayer mp1;
    ImageView imgview, imgview3;
    int counter=1;
    int decdigit = 0;
    TextView tv;
    private int _xDelta;
    private int _yDelta;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        learn si = new learn();
        si.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        imgview = (ImageView ) findViewById(R.id.imgview);
        imgview3 = (ImageView ) findViewById(R.id.imageView3);
        tv = (TextView) findViewById(R.id.textView);
       // imgview.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
      //  imgview.playSoundEffect(SoundEffectConstants.CLICK);

        // Assign the touch listener to your view which you want to move
        findViewById(R.id.imgbee).setOnTouchListener(new MyTouchListener1());
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
            }
        });
        tv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mp1.start();
            }
        });
        bt_hom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(learn.this,menu.class);
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
    void checkfunction (int inputer){
        //mp1 = MediaPlayer.create(learn.this, R.raw.md);
        //mp1.start();


        String tester="0";
        int calcu = 10*decdigit + counter;
        if (inputer==1) {}
        if (inputer==2){}
        if (inputer==3){}
        if (inputer==4){}
        if (s.equals("1")){
            imgview3.setImageResource(R.drawable.lbgcolors);
            if (calcu==1) { tester ="101"; imgview.setImageResource(R.drawable.redapple);tv.setText("RED");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==2) { tester ="102";imgview.setImageResource(R.drawable.fireengine);tv.setText("RED");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==3) { tester ="103";imgview.setImageResource(R.drawable.cherry);tv.setText("RED"); mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==4) { tester ="104";imgview.setImageResource(R.drawable.rose);tv.setText("RED");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}

            if (calcu == 11){tester ="111"; imgview.setImageResource(R.drawable.balloons);tv.setText("BLUE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu == 12){tester ="112"; imgview.setImageResource(R.drawable.cap);tv.setText("BLUE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu == 13){tester ="113"; imgview.setImageResource(R.drawable.fish);tv.setText("BLUE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu == 14){tester ="114"; imgview.setImageResource(R.drawable.marbles);tv.setText("BLUE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
                /*if ((10*decdigit + counter)==11) {tester ="11"; imgview.setImageResource(R.drawable.balloons);} else {imgview.setImageResource(R.drawable.cap);}
            if ((10*decdigit + counter)==12) {tester ="12"; imgview.setImageResource(R.drawable.cap);} else {imgview.setImageResource(R.drawable.cap);}
            if ((10*decdigit + counter)==13) {tester ="13"; imgview.setImageResource(R.drawable.fish);} else {imgview.setImageResource(R.drawable.cap);}
            if ((10*decdigit + counter)==14) {tester ="14";imgview.setImageResource(R.drawable.marbles);} else {imgview.setImageResource(R.drawable.cap);}*/
          //  Toast tt = Toast.makeText(this,counter+ tester,Toast.LENGTH_SHORT);
          //  tt.show();
        }
        if (s.equals("2")){
            imgview3.setImageResource(R.drawable.lbgshapes);
            if (calcu==1) { tester ="201"; imgview.setImageResource(R.drawable.chocolate);tv.setText("SQUARE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==2) { tester ="202";imgview.setImageResource(R.drawable.cushion);tv.setText("SQUARE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==3) { tester ="203";imgview.setImageResource(R.drawable.photoframe);tv.setText("SQUARE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==4) { tester ="204";imgview.setImageResource(R.drawable.chess);tv.setText("SQUARE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==11) { tester ="211"; imgview.setImageResource(R.drawable.ball);tv.setText("CIRCLE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==12) { tester ="212";imgview.setImageResource(R.drawable.button);tv.setText("CIRCLE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==13) { tester ="213"; imgview.setImageResource(R.drawable.pizza);tv.setText("CIRCLE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==14) { tester ="214";imgview.setImageResource(R.drawable.plate);tv.setText("CIRCLE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==21) { tester ="221"; imgview.setImageResource(R.drawable.hanger);tv.setText("TRIANGLE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==22) { tester ="222";imgview.setImageResource(R.drawable.yacht);tv.setText("TRIANGLE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==23) { tester ="223"; imgview.setImageResource(R.drawable.sandwich);tv.setText("TRIANGLE");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==24) { tester ="224";imgview.setImageResource(R.drawable.roadsign);tv.setText("TRIANGLE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter>4) {counter=0;}
            if (decdigit>2) {decdigit=-1;}
        }
        if (s.equals("3")){
            imgview3.setImageResource(R.drawable.lbgalpha);
            if (calcu==1) { tester ="1";imgview.setImageResource(R.drawable.alphaa);tv.setText("A");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==2) { tester ="2"; imgview.setImageResource(R.drawable.apple);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==3) { tester ="3";imgview.setImageResource(R.drawable.arrow);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==4) { tester ="4";imgview.setImageResource(R.drawable.ant);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==5) { tester ="5";imgview.setImageResource(R.drawable.aeroplane);tv.setText("A");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==11) { tester ="6";imgview.setImageResource(R.drawable.alphab);tv.setText("B");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==12) { tester ="7"; imgview.setImageResource(R.drawable.ball);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==13) { tester ="8";imgview.setImageResource(R.drawable.balloons);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==14) { tester ="9"; imgview.setImageResource(R.drawable.basket);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==15) { tester ="10";imgview.setImageResource(R.drawable.book);tv.setText("B");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==21) { tester ="11"; imgview.setImageResource(R.drawable.alphac);tv.setText("C");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==22) { tester ="12"; imgview.setImageResource(R.drawable.cake);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==23) { tester ="13";imgview.setImageResource(R.drawable.car);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (calcu==24) { tester ="14"; imgview.setImageResource(R.drawable.cat);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (calcu==25) { tester ="15";imgview.setImageResource(R.drawable.cap);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter>5) {counter=0;}
            if (decdigit>2) {decdigit=-1;}
        }
        if (s.equals("4")){
            imgview3.setImageResource(R.drawable.lbgnumbers);
            tv.setText("NUMBERS");
            if (counter==1) { tester ="401"; imgview.setImageResource(R.drawable.number1);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==2) { tester ="402";imgview.setImageResource(R.drawable.sun);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter==3) { tester ="403";imgview.setImageResource(R.drawable.number2);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==4) { tester ="404"; imgview.setImageResource(R.drawable.shoes);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==5) { tester ="405";imgview.setImageResource(R.drawable.number3);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter==6) { tester ="406";imgview.setImageResource(R.drawable.ducks);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter>6) {counter=0;}
        }
        if (s.equals("5")){
            imgview3.setImageResource(R.drawable.lbganimal);
            tv.setText("ANIMALS");
            if (counter==1) { tester ="501"; imgview.setImageResource(R.drawable.cat);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==2) { tester ="502";imgview.setImageResource(R.drawable.dog);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter==3) { tester ="503";imgview.setImageResource(R.drawable.cow);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==4) { tester ="504";imgview.setImageResource(R.drawable.lion);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter==5) { tester ="505"; imgview.setImageResource(R.drawable.elephant);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==6) { tester ="506";imgview.setImageResource(R.drawable.giraffe);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter>6) {counter=0;}
        }
        if (s.equals("6")){
            imgview3.setImageResource(R.drawable.lbgveg);
            tv.setText("VEGETABLES");
            if (counter==1) { tester ="601"; imgview.setImageResource(R.drawable.tomato);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==2) { tester ="602";imgview.setImageResource(R.drawable.potato);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter==3) { tester ="603";imgview.setImageResource(R.drawable.cabbage);mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==4) { tester ="604";imgview.setImageResource(R.drawable.greenpeas);mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter>4) {counter=0;}
        }
        if (s.equals("7")){
            imgview3.setImageResource(R.drawable.lbgfruit);
            if (counter==1) { tester ="701"; imgview.setImageResource(R.drawable.banana);tv.setText("BANANA");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==2) { tester ="702";imgview.setImageResource(R.drawable.pomgranate);tv.setText("POMGRENADE");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter==3) { tester ="703";imgview.setImageResource(R.drawable.cherry);tv.setText("CHERRY");mp1 = MediaPlayer.create(this, R.raw.one);mp1.start();}
            if (counter==4) { tester ="704";imgview.setImageResource(R.drawable.mango);tv.setText("MANGO");mp1 = MediaPlayer.create(this, R.raw.two);mp1.start();}
            if (counter>4) {counter=0;}
        }
          /*  if ((10*decdigit + counter)==1) { imgview.setImageResource(R.drawable.redapple);} else {imgview.setImageResource(R.drawable.fireengine);}       // imgview.setBackgroundResource(R.drawable.redapple);
            if ((10*decdigit + counter)==2) { imgview.setImageResource(R.drawable.fireengine);} else {imgview.setImageResource(R.drawable.fireengine);}       // imgview.setBackgroundResource(R.drawable.redapple);
            if ((10*decdigit + counter)==3) { imgview.setImageResource(R.drawable.cherry);} else {imgview.setImageResource(R.drawable.fireengine);}
            if ((10*decdigit + counter)==4) { imgview.setImageResource(R.drawable.rose);} else {imgview.setImageResource(R.drawable.fireengine);}
            if ((10*decdigit + counter)==11) { imgview.setImageResource(R.drawable.balloons);} else {imgview.setImageResource(R.drawable.cap);}       // imgview.setBackgroundResource(R.drawable.redapple);
            if ((10*decdigit + counter)==12) { imgview.setImageResource(R.drawable.cap);} else {imgview.setImageResource(R.drawable.cap);}       // imgview.setBackgroundResource(R.drawable.redapple);
            if ((10*decdigit + counter)==13) { imgview.setImageResource(R.drawable.cherry);} else {imgview.setImageResource(R.drawable.cap);}
            if ((10*decdigit + counter)==14) { imgview.setImageResource(R.drawable.rose);} else {imgview.setImageResource(R.drawable.cap);}*/

        //}

    }
    // This defines your touch listener
    private final class MyTouchListener1 implements OnTouchListener {
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
    /*
    private final class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.shape_droptarget);
        Drawable normalShape = getResources().getDrawable(R.drawable.shape);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    FrameLayout container = (FrameLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }*/
}
