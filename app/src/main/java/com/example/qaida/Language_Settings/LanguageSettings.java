package com.example.qaida.Language_Settings;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qaida.Language_Settings.LocaleHelper;
import com.example.qaida.R;
import com.example.qaida.Splash_and_Menu.menu_screen;

public class LanguageSettings extends AppCompatActivity {
    Context context ;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_settings_activity);

        RadioGroup radioGroup = findViewById(R.id.group);
        TextView textView = findViewById(R.id.textViewLanguageSelection);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if (rb!=null){
                    switch(checkedId) {
                        case R.id.english:
                            // do operations specific to this selection
                            context = LocaleHelper.setLocale(getBaseContext(), "en");
                            resources = context.getResources();
                            textView.setText(resources.getString(R.string.selectedLanguage));
                            break;
                        case R.id.urdu:
                            context = LocaleHelper.setLocale(getBaseContext(), "ur");
                            resources = context.getResources();
                            textView.setText(resources.getString(R.string.selectedLanguage));

                        default:
                    }

                }
            }
        });
        Button button = findViewById(R.id.continueButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu_screen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(context,menu_screen.class);
        startActivity(intent);
        finish();
    }
}