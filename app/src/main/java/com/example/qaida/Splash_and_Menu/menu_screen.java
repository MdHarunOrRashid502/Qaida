package com.example.qaida.Splash_and_Menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qaida.Language_Settings.LocaleHelper;
import com.example.qaida.R;

import java.util.ArrayList;
import java.util.Locale;

public class menu_screen extends AppCompatActivity {

    Context context;
    RecyclerView.LayoutManager mLayoutManager;
    MenuAdapter mAdapter;
    MenuAdapter menuAdapter;
    RecyclerView recyclerView;
    Boolean lang_selected = true;
    Resources resources;
    DialogInterface dialogInterface;
    AppCompatButton object;

    MenuAdapter.OnItemClickListener listener;


    ImageView bottom_flower;
    ImageView logoImage;
    ArrayList<Menu_index_list> menuInexes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadLocal();
        setContentView(R.layout.activity_menu_screen);
        ImageButton settingImg = findViewById(R.id.imageBtnSetting);
        recyclerView = findViewById(R.id.recyclerViewforIndex);
        CardView menuView = findViewById(R.id.menu_item_view);
        Button menubtn = findViewById(R.id.btnIndexList);
        object = findViewById(R.id.btnIndexList);

        bottom_flower = findViewById(R.id.flower_bottom);
        logoImage = findViewById(R.id.logoImage);


        logoImage.bringToFront();
        recyclerView.bringToFront();

        //call recyclerview function for show indexList
        RecyclerViewShowIndex();
        settingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] Language = {"ENGLISH", "اردو"};
                final int checkedItem;
                if(lang_selected)
                {
                    checkedItem=0;
                }else
                {
                    checkedItem=1;
                }

                final AlertDialog.Builder builder = new AlertDialog.Builder(menu_screen.this);
                builder.setTitle(getResources().getString(R.string.selectedLanguage))
                        .setSingleChoiceItems(Language, checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                lang_selected= Language[which].equals("ENGLISH");
                                //if user select prefered language as English then
                                if(Language[which].equals("ENGLISH"))
                                {
                                    context = LocaleHelper.setLocale(menu_screen.this, "en");
                                    resources = context.getResources();
                                    builder.setTitle(resources.getString(R.string.selectedLanguage));
                                    RecyclerViewShowIndex(resources);
                                    setLocal("en");
                                   // text1.setText(resources.getString(R.string.language));

                                }
                                //if user select prefered language as urdu then
                                if(Language[which].equals("اردو"))
                                {
                                    context = LocaleHelper.setLocale(menu_screen.this, "ur");
                                    resources = context.getResources();
                                    builder.setTitle(resources.getString(R.string.selectedLanguage));
                                    RecyclerViewShowIndex(resources);
                                    setLocal("ur");
                                   // text1.setText(resources.getString(R.string.language));
                                }
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialogInterface = dialog;
                                dialog.dismiss();
                            }
                        });
                builder.create().show();
            }
        });

    }

    public  void RecyclerViewShowIndex(){
        menuInexes = new ArrayList<>();
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_1)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_2)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_3)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_4)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_5)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_6)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_7)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_8)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_9)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_10)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_11)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_12)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_13)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_14)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_15)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_16)));
        menuInexes.add(new Menu_index_list(getString(R.string.Lesson_17)));
        mLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        mAdapter = new MenuAdapter(menuInexes);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        menuAdapter = new MenuAdapter(menuInexes);

        mAdapter.setOnItemClickListener(new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("Clicked","Clicked");
                String string = menuInexes.get(position).getText1().toString();
                Log.i("right",string);
            }
        });
    }
    public  void RecyclerViewShowIndex(Resources resources){
        menuInexes = new ArrayList<>();
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_1)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_2)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_3)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_4)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_5)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_6)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_7)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_8)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_9)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_10)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_11)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_12)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_13)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_14)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_15)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_16)));
        menuInexes.add(new Menu_index_list(resources.getString(R.string.Lesson_17)));
        mLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        mAdapter = new MenuAdapter(menuInexes);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        menuAdapter = new MenuAdapter(menuInexes);

        mAdapter.setOnItemClickListener(new MenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("Clicked","Clicked");
                String string = menuInexes.get(position).getText1().toString();
                Log.i("right",string);
            }
        });
    }
    public void jumpFromDownAnim(View view) {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_jump_from_down);
        object.startAnimation(anim);
    }


    private void setLocal(String language)
    {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("languageToLoad",language);
        editor.apply();
    }
    public void LoadLocal(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("languageToLoad","");
        setLocal(language);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}