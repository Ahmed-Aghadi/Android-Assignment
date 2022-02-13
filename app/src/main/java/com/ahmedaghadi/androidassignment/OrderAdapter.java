package com.ahmedaghadi.androidassignment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class OrderAdapter extends ArrayAdapter<Order> {

    public OrderAdapter(@NonNull Context context, ArrayList<Order> orders) {
        super(context, 0, orders);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.order_item, parent, false);
        }

        Order currentOrder = getItem(position);

        TextView orderIdTextView = listItemView.findViewById(R.id.id_textView);
        TextView timeStampTextView = listItemView.findViewById(R.id.timestamp_textView);
        TextView itemCountTextView = listItemView.findViewById(R.id.itemCount_textView);
        TextView priceTextView = listItemView.findViewById(R.id.price_textView);
        TextView statusTextView = listItemView.findViewById(R.id.status_textView);
        LinearLayout isNewLinearLayout = listItemView.findViewById(R.id.new_linearLayout);

        LinearLayout statusLinearLayout = listItemView.findViewById(R.id.status_linearLayout);

        orderIdTextView.setText("Order #" + currentOrder.getId());

        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        try {
            Date timeStamp = df.parse(currentOrder.getTimestamp());
            long different = currentDate.getTime() - timeStamp.getTime();

            long elapsedDays = different / 86400000;

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
            Date timeStamp2 = sdf.parse(currentOrder.getTimestamp());
            String timeElapsed = sdf.format(timeStamp2);

            SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inFormat.parse(currentOrder.getTimestamp());
            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
            String day = outFormat.format(date);

            if(elapsedDays == 0){
                timeStampTextView.setText("Today, " + timeElapsed);
            }else if(elapsedDays == 1){
                timeStampTextView.setText("Yesterday, " + timeElapsed);
            }else{
                timeStampTextView.setText(day + ", " + timeElapsed);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


        int itemCount = currentOrder.getItemCount();

        if(itemCount > 1){
            itemCountTextView.setText(itemCount + " ITEMS");
        }else{
            itemCountTextView.setText(itemCount + " ITEM");
        }

        if(!currentOrder.isNew()){
            isNewLinearLayout.setVisibility(View.INVISIBLE);
        }

        if(currentOrder.getStatus().equals("paid")){
            statusTextView.setText("paid");
            statusLinearLayout.setBackgroundResource(R.drawable.roundborder6_1);
        }
        priceTextView.setText(currentOrder.getPrice());

        return listItemView;
    }
}
