package com.pacecon.parag.brainapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class menu extends AppCompatActivity  implements OnClickListener {

    ImageButton btn_validation, btn_color, btn_sett, btn_compliance, btn_run, btn_reports, btn_people, btn_numbers;
    MediaPlayer mediaPlayer1, mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu si = new menu();
        si.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        //  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // fab.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //   public void onClick(View view) {
        //       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //             .setAction("Action", null).show();
        //     }
        // });
        //}



       /*
         MediaPlayer mp = new MediaPlayer();
      //  MediaPlayer mpr = MediaPlayer.create(this, R.raw.sound);
        Toast t1 = Toast.makeText(this,"H" + Environment.getExternalStorageDirectory().toString(),Toast.LENGTH_SHORT);
        t1.show();
        try{
            mp.setDataSource(Environment.getExternalStorageDirectory().toString()+"/Music/md.wav");//Write your location here
           // mp.setDataSource(Environment.getExternalStorageDirectory().toString()+"/Music/md.wav");
           // mp.prepare();
            //AssetFileDescriptor afd;
           // afd = getAssets().openFd("/music/md.wav");
          //  mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mp.start();
            Toast t11 = Toast.makeText(this,"md reached",Toast.LENGTH_SHORT);
            t11.show();

        }catch(Exception e){e.printStackTrace();
            Toast tt = Toast.makeText(this,e.toString()+ "md",Toast.LENGTH_SHORT);
        tt.show();}*/

        // mediaPlayer1 = MediaPlayer.create(this, R.raw.md);
        btn_compliance = (ImageButton) findViewById(R.id.btn_compliance);
        btn_run = (ImageButton) findViewById(R.id.btn_run);
        btn_color = (ImageButton) findViewById(R.id.btn_color);
        btn_reports = (ImageButton) findViewById(R.id.btn_reports);
        btn_validation = (ImageButton) findViewById(R.id.btn_validation);
        btn_sett = (ImageButton) findViewById(R.id.btn_sett);
        btn_people = (ImageButton) findViewById(R.id.btn_people);
        btn_numbers = (ImageButton) findViewById(R.id.btn_numbers);



        //btn_color.setOnClickListener(this);
        btn_color.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "1");
                startActivity(i);

                ArrayList<String> urls = new ArrayList<String>(); //to read each line
                TextView t; //to show the result
                t = (TextView) findViewById(R.id.textViewtest);
                try {
                    // Create a URL for the desired page
                    URL url = new URL("jsfa.in/test.txt"); //My text file location
                    // Read all the text returned by the server
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));


                    String str;
                    while ((str = in.readLine()) != null) {
                        urls.add(str);
                    }
                    in.close();
                } catch (MalformedURLException e) {
                } catch (IOException e) {
                }
                t.setText(urls.get(0)); // My TextFile has 3 lines
            }
        });
        btn_run.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String data = "hello";
                    URL u1 = new URL("http://jsfa.in/test.txt");
                    URLConnection uc1 = u1.openConnection();
                    uc1.setDoOutput(true);
                    OutputStreamWriter out = new OutputStreamWriter(uc1.getOutputStream());
                    out.write(data);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "2");
                startActivity(i);
            }
        });
        btn_reports.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer2 = MediaPlayer.create(menu.this, R.raw.oph);
                mediaPlayer2.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "3");
                startActivity(i);
            }
        });

        btn_numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "4");
                startActivity(i);
            }
        });
        btn_validation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "5");       //animal
                startActivity(i);
            }
        });
        btn_people.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();

                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "6"); //vegetable
                startActivity(i);
            }
        });
        btn_compliance.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "7");
                startActivity(i);
            }
        });


        btn_sett.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer1 = MediaPlayer.create(menu.this, R.raw.md);
                mediaPlayer1.start();
                Intent i = new Intent(menu.this, index.class);
                i.putExtra("caller", "8");
                startActivity(i);
            }
        });


    }

    @Override
    public void onClick(View v) {
        {
            try {
                //  CheckFunct(v);
            } catch (Exception e) {
                Toast toast = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

        public void CheckFunct(View v)
        {
            if(v==btn_color)
            {

                //ActionBar actionBar = getSupportActionBar();
                //actionBar.hide();
                //mp.start();
            }
            else if(v==btn_run)
            {
                Intent i=new Intent(this,index.class);
                //finish();
                i.putExtra("caller","1");
                startActivity(i);
            }
            else if(v==btn_reports)
            {
                Intent i=new Intent(this,index.class);
                i.putExtra("caller","3");
                startActivity(i);
            }
            else if(v==btn_validation)
            {
                Intent i=new Intent(this,index.class);
                i.putExtra("caller","4");
                // finish();
                startActivity(i);
            }

            else if(v==btn_compliance )
            {
                Intent i=new Intent(this,index.class);
                startActivity(i);
            }

            else if(v==btn_sett )
            {
                Intent i=new Intent(this,index.class);
                startActivity(i);
            }
        }
    }

