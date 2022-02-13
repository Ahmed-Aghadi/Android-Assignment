package com.ahmedaghadi.androidassignment;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class QueryUtils {

    private QueryUtils() {
    }

    static List<Filter> extractFilterJson(String jsonData){
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }

        List<Filter> filters = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(jsonData);
            JSONObject results = baseJsonResponse.getJSONObject("results");
            JSONArray filterArray = results.getJSONArray("filter");

            for (int i = 0; i < filterArray.length(); i++){
                JSONObject currentFilter = filterArray.getJSONObject(i);

                int id = currentFilter.getInt("id");
                int count = currentFilter.getInt("count");
                String name = currentFilter.getString("name");
                Log.e("filterData", id + " " + name + " " + count);
                Filter filter = new Filter(id,name,count);

                filters.add(filter);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the filter JSON results: ", e);
        }

        return filters;
    }

    static List<Order> extractOrderJson(String jsonData){
        if (TextUtils.isEmpty(jsonData)) {
            return null;
        }

        List<Order> orders = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(jsonData);
            JSONObject results = baseJsonResponse.getJSONObject("results");
            JSONArray orderArray = results.getJSONArray("order");

            for (int i = 0; i < orderArray.length(); i++){
                JSONObject currentOrder = orderArray.getJSONObject(i);

                int id = currentOrder.getInt("id");
                String timestamp = currentOrder.getString("timestamp");
                int itemCount = currentOrder.getInt("item_count");
                String  price = currentOrder.getString("price");
                String status = currentOrder.getString("status");
                int type = currentOrder.getInt("type");
                boolean isNew = currentOrder.getBoolean("is_new");

                Order order = new Order(id,timestamp,itemCount,price,status,type,isNew);

                orders.add(order);
            }
        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the filter JSON results: ", e);
        }

        return orders;
    }
}
