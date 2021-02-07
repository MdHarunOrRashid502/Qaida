package com.example.qaida.Splash_and_Menu;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qaida.Lessons.Lesson_1;
import com.example.qaida.Lessons.Lesson_2;
import com.example.qaida.Lessons.Lesson_one_item;
import com.example.qaida.MainActivity;
import com.example.qaida.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuAdapterViewHolder> {
    private ArrayList<Menu_index_list> mExampleList;
    Context context;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class MenuAdapterViewHolder extends RecyclerView.ViewHolder {
        public Button mTextView1;
        public MenuAdapterViewHolder(View itemView,final OnItemClickListener listener) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.btnIndexList);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }


    }
    public MenuAdapter(ArrayList<Menu_index_list> exampleList) {
        mExampleList = exampleList;
    }
    @Override
    public MenuAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_index_design, parent, false);
        MenuAdapterViewHolder evh = new MenuAdapterViewHolder(v,mListener);
        context = parent.getContext();
        return evh;
    }
    @Override
    public void onBindViewHolder(MenuAdapterViewHolder holder, int position) {
        Menu_index_list currentItem = mExampleList.get(position);
        holder.mTextView1.setText(currentItem.getText1());


        holder.mTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;

                switch (position){
                    case 0:
                        intent = new Intent(context, Lesson_1.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                         intent = new Intent(context, Lesson_2.class);
                        context.startActivity(intent);
                        break;

                }

            }
        });

            setAnimation(holder.itemView, position);

    }

    @Override
    public void onViewDetachedFromWindow(@NonNull MenuAdapterViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim_slide_left);
        animation.setDuration(500);
        holder.itemView.setAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
    private int lastPosition = -1;

    private void setAnimation(View viewToAnimate, int position) {

        if (position % 2 ==0) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.menu_button_animation);
            animation.setDuration(500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        } else{
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.menu_button_animation);
            animation.setDuration(500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
