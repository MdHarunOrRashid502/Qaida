package com.example.qaida.Lessons;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qaida.R;
import com.example.qaida.Splash_and_Menu.Menu_index_list;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.example.qaida.R.layout.lesson_recycler_item;

public class Lesson_1_Adapter extends RecyclerView.Adapter<Lesson_1_Adapter.MenuAdapterViewHolder> {
    private ArrayList<Lesson_one_item> mExampleList;
    Context context;
    boolean clicked=false;
    MediaPlayer mp;
    int previous = -1;
    MenuAdapterViewHolder menuAdapterViewHolder;


    private final ClickListener listener;

    public interface ClickListener {

        void onPositionClicked(int position);
    }

    public static class MenuAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView audioSpeaker;
        public Button btnRules;
        public TextView textView1,textView2;
        RelativeLayout relativeLayout;

        private WeakReference<ClickListener> listenerRef;


        public MenuAdapterViewHolder(final  View itemView,ClickListener listener) {
            super(itemView);
            //audioSpeaker = itemView.findViewById(R.id.lesson_1_audioIcon);
          //  btnRules = itemView.findViewById(R.id.rulesIcon);
            listenerRef = new WeakReference<>(listener);
            textView1 = itemView.findViewById(R.id.lesson_1_alphabetText1);
            textView2 = itemView.findViewById(R.id.lesson_1_alphabetText2);
            relativeLayout = itemView.findViewById(R.id.mainBtn);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            listenerRef.get().onPositionClicked(getAdapterPosition());
        }
    }
    public Lesson_1_Adapter(ArrayList<Lesson_one_item> exampleList,ClickListener listener) {
        mExampleList = exampleList;
       // mp = mediaPlayer;
        this.listener = listener;
    }
    @Override
    public MenuAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      //  return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row_layout), parent, false), listener);
        View v = LayoutInflater.from(parent.getContext()).inflate(lesson_recycler_item, parent, false);
       MenuAdapterViewHolder evh = new MenuAdapterViewHolder(v,listener);
        context = parent.getContext();
        return evh;
    }
    @Override
    public void onBindViewHolder(MenuAdapterViewHolder holder, int position) {
        Lesson_one_item currentItem = mExampleList.get(position);

        holder.textView1.setText(currentItem.getTextView1());
        holder.textView2.setText(currentItem.getTextView2());
        menuAdapterViewHolder = holder;



       /* holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previous == -1) {
                    previous = position;
                    mp.start();
                    Toast.makeText(context, Integer.toString(position) + " "+ Integer.toString(previous), Toast.LENGTH_SHORT).show();
                } else if (previous == position) {
                    Toast.makeText(context, Integer.toString(position) + " "+ Integer.toString(previous), Toast.LENGTH_SHORT).show();
                    if (mp.isPlaying()) {
                        //check if a song is already playing
                        mp.stop();
                        try {
                            mp.prepare();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } else {
                        mp.start();
                        Animation animation = AnimationUtils.loadAnimation(context, R.anim.menu_button_animation);
                        animation.setDuration(500);
                        v.startAnimation(animation);

                    }
                    previous = position;
                } else {
                    if (!mp.isPlaying()) {
                        //check if a song is already playing
                        mp.start();
                    }
                    else {
                        mp.stop();
                        try {
                            mp.prepare();
                            mp.start();
                        } catch (IllegalStateException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    previous = position;


                }
            }

        }); */
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
