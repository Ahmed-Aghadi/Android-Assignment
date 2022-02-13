package com.ahmedaghadi.androidassignment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class OrderLoader extends AsyncTaskLoader<List<Order>> {

    private String mJsonData;

    public OrderLoader(@NonNull Context context, String jsonData) {
        super(context);
        mJsonData = jsonData;
    }

    @Nullable
    @Override
    public List<Order> loadInBackground() {
        if (mJsonData == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Order> orders = QueryUtils.extractOrderJson(mJsonData);
        return orders;
    }
}
