package com.ahmedaghadi.androidassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MyViewHolder> {
    private List<Filter> mFilterList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView status;
        MyViewHolder(View view) {
            super(view);
            status = view.findViewById(R.id.status);
        }
    }

    public FilterAdapter(ArrayList<Filter> filterList) {
        mFilterList = filterList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filter_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filter currentFilter = mFilterList.get(position);

        String status = currentFilter.getName() + " (" + currentFilter.getCount() + ")";

        holder.status.setText(status);
    }


    @Override
    public int getItemCount() {
        return mFilterList.size();
    }
}
