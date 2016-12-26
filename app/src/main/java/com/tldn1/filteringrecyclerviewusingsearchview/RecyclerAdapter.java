package com.tldn1.filteringrecyclerviewusingsearchview;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by X on 12/26/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<Model> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Model model = arrayList.get(position);

        holder.txtTitle.setText(model.getTitle());
        holder.imageView.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView txtTitle;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        }
    }

    public void setFilter(ArrayList<Model> modelList){
        arrayList = new ArrayList<>();
        arrayList.addAll(modelList);
        notifyDataSetChanged();
    }
}
