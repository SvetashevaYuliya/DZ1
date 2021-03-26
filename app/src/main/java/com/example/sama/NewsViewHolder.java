package com.example.sama;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  //  private final ImageView img;
    private final TextView title;
  //  private final TextView date;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        title.setOnClickListener((View.OnClickListener) this);
    }

    public void bind(Model_Item model) {//наполняет viewHolder данными, прилетающими из адаптера
        title.setText(model.mTitle);
        title.setTextColor(model.mColor);
    }

    @Override
    public void onClick(View v) {
        int position =getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            FragmentTransaction fragmentTransaction;
            Fragment2 fragment2 = new Fragment2();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            Bundle bundle = new Bundle();
            bundle.putInt("Number", position+1);
            if((position+1)%2==1)
                bundle.putInt("Color", Color.BLUE);
            else
                bundle.putInt("Color", Color.RED);
            fragment2.setArguments(bundle);
        }
    }


}
