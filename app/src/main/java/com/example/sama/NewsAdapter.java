package com.example.sama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    List<Model_Item> data= DataSource.getInstance().getRemoteData();
    public void insert(Model_Item newMod)
    {
        data.add(newMod);
        notifyItemInserted(data.size()-1);
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Model_Item model =data.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}