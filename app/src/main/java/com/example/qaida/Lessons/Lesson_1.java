package com.example.qaida.Lessons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qaida.R;
import com.example.qaida.Splash_and_Menu.MenuAdapter;
import com.example.qaida.Splash_and_Menu.Menu_index_list;

import java.util.ArrayList;

public class Lesson_1 extends AppCompatActivity {
    private  RecyclerView.LayoutManager  mLayoutManager;
    private Lesson_1_Adapter mAdapter;
    private  RecyclerView recyclerView;
    private ArrayList<Lesson_one_item> LessonOneIndex;
    RelativeLayout relativeLayout;
    private ArrayList<Integer> mediaPlayers;
    public static   MediaPlayer mp =null;
    public boolean AllButtonAudiocontrol = false;
    private int previous = -1;
    private RelativeLayout rulesButtonLayout;

    Boolean controlRuleButton = false;


    CardView ItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_1);

        recyclerView = findViewById(R.id.lesson1RecyclerVeiw);
        relativeLayout = findViewById(R.id.mainBtn);
        ItemView = findViewById(R.id.itemView);
        rulesButtonLayout =findViewById(R.id.rulesLayoutLesson1);


        initializeAlphabetList();
        buildRecyclerView();

    }


    public void buildRecyclerView() {
        mLayoutManager = new GridLayoutManager(this, 2);
        mAdapter = new Lesson_1_Adapter(LessonOneIndex, new Lesson_1_Adapter.ClickListener() {
            @Override
            public void onPositionClicked(int position) {
                AudioPlay(position);
            }
        });
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

    }
    public void AudioPlay(int position){
        if(!AllButtonAudiocontrol && previous == -1)
        {
            if(controlRuleButton){
                AudioSetRules(position);
            }else
            {
                AudioSetAlphabet(position);
            }

            Animation(recyclerView.findViewHolderForAdapterPosition(position));
            mp.start();
            previous = position;
            AllButtonAudiocontrol = true;
        }else if(previous == position){
            if(mp != null && mp.isPlaying())
            {
                mp.stop();
            }else
            {
                if(controlRuleButton){
                    AudioSetRules(position);
                }else
                {
                    AudioSetAlphabet(position);
                }
                Animation(recyclerView.findViewHolderForAdapterPosition(position));
                mp.start();
                previous = position;
                AllButtonAudiocontrol = true;
            }
        }else
        {
            if(mp != null && mp.isPlaying())
            {
                mp.stop();
            }
            if(controlRuleButton){
                AudioSetRules(position);
            }else
            {
                AudioSetAlphabet(position);
            }
            Animation(recyclerView.findViewHolderForAdapterPosition(position));
            mp.start();
            previous = position;
            AllButtonAudiocontrol = true;
        }

    }
    public void AudioSetAlphabet(int position){
        if (position == 0) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.a);
        } else if (position  == 1) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.b);
        } else if (position == 2) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.c);
        } else if (position == 3) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.d);
        } else if (position == 4) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.e);
        }else if (position == 5) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.f);
        }else if (position == 6) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.g);
        }else if (position == 7) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.h);
        }else if (position == 8) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.i);
        }else if (position == 9) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.j);
        }else if (position == 10) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.k);
        }else if (position == 11) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.l);
        }else if (position == 12) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.m);
        }else if (position == 13) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.n);
        }else if (position == 14) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.o);
        }else if (position == 15) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.p);
        }else if (position == 16) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.q);
        }else if (position == 17) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.r);
        }else if (position == 18) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.s);
        }else if (position == 19) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.t);
        }else if (position == 20) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.u);
        }else if (position == 21) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.v);
        }else if (position == 22) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.w);
        }else if (position == 23) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.x);
        }else if (position == 24) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.y);
        }else if (position == 25) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.z);
        }else if (position == 26) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.aa);
        }else if (position == 27) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.ab);
        }else if (position == 28) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.ac);
        }else if (position == 29) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.ac);
        }
    }
    public void AudioSetRules(int position){
        if (position == 0) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_1);
        } else if (position  == 1) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_2);
        } else if (position == 2) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_3);
        } else if (position == 3) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_4);
        } else if (position == 4) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_5);
        }else if (position == 5) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_6);
        }else if (position == 6) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_7);
        }else if (position == 7) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_8);
        }else if (position == 8) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_9);
        }else if (position == 9) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_10);
        }else if (position == 10) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_11);
        }else if (position == 11) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_12);
        }else if (position == 12) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_13);
        }else if (position == 13) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_14);
        }else if (position == 14) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_15);
        }else if (position == 15) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_16);
        }else if (position == 16) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_17);
        }else if (position == 17) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_18);
        }else if (position == 18) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_19);
        }else if (position == 19) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_20);
        }else if (position == 20) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_21);
        }else if (position == 21) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_22);
        }else if (position == 22) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_23);
        }else if (position == 23) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_24);
        }else if (position == 24) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_25);
        }else if (position == 25) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_26);
        }else if (position == 26) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_27);
        }else if (position == 27) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_28);
        }else if (position == 28) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_29);
        }else if (position == 29) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.rules_29);
        }
    }

    public void Animation(RecyclerView.ViewHolder viewHolder)
    {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.menu_button_animation);
        animation.setDuration(500);
        viewHolder.itemView.startAnimation(animation);
    }
    private void initializeAlphabetList() {
        LessonOneIndex = new ArrayList<>();
        LessonOneIndex.add(new Lesson_one_item("الف","ا"));
        LessonOneIndex.add(new Lesson_one_item("با","ب"));
        LessonOneIndex.add(new Lesson_one_item("تا","ت"));
        LessonOneIndex.add(new Lesson_one_item("ثا","ث"));
        LessonOneIndex.add(new Lesson_one_item("جیم","ج"));
        LessonOneIndex.add(new Lesson_one_item("حا","ح"));
        LessonOneIndex.add(new Lesson_one_item("خا","خ"));
        LessonOneIndex.add(new Lesson_one_item("دال","د"));
        LessonOneIndex.add(new Lesson_one_item("ذال","ذ"));
        LessonOneIndex.add(new Lesson_one_item("را","ر"));
        LessonOneIndex.add(new Lesson_one_item("زا","ز"));
        LessonOneIndex.add(new Lesson_one_item("سین","س"));
        LessonOneIndex.add(new Lesson_one_item("شین","ش"));
        LessonOneIndex.add(new Lesson_one_item("صاد","ص"));
        LessonOneIndex.add(new Lesson_one_item("ضاد","ض"));
        LessonOneIndex.add(new Lesson_one_item("طا","ط"));
        LessonOneIndex.add(new Lesson_one_item("ظا","ظ"));
        LessonOneIndex.add(new Lesson_one_item("عین","ع"));
        LessonOneIndex.add(new Lesson_one_item("غین","غ"));
        LessonOneIndex.add(new Lesson_one_item("فا","ف"));
        LessonOneIndex.add(new Lesson_one_item("قاف","ق"));
        LessonOneIndex.add(new Lesson_one_item("کاف","ک"));
        LessonOneIndex.add(new Lesson_one_item("لام","ل"));
        LessonOneIndex.add(new Lesson_one_item("میم","م"));
        LessonOneIndex.add(new Lesson_one_item("نون","ن"));
        LessonOneIndex.add(new Lesson_one_item("واء","و"));
        LessonOneIndex.add(new Lesson_one_item("ھا","ھ"));
        LessonOneIndex.add(new Lesson_one_item("ھمزہ","ء"));
        LessonOneIndex.add(new Lesson_one_item("یا","ی"));
        LessonOneIndex.add(new Lesson_one_item("یا","ے"));
    }
    public void IntruductionButtonControl(View v){
        if(mp != null && mp.isPlaying()){
            mp.stop();
        }
        mp = MediaPlayer.create(getApplicationContext(),R.raw.intruduction_1);
        mp.start();
    }

    public void RulesButtonControl(View view){
        if(mp != null && mp.isPlaying()){
            mp.stop();
        }
       if(!controlRuleButton){
           rulesButtonLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.goldenColor));
           controlRuleButton = true;
       }else{
           rulesButtonLayout.setBackgroundResource(R.drawable.greadient_background_subtitile_lesson_1_end);
           controlRuleButton = false;
       }
    }



}