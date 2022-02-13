package com.ahmedaghadi.androidassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Order>> {

    private String mJsonData = "{\n" +
            "  \"count\": 2,\n" +
            "  \"next\": null,\n" +
            "  \"previous\": null,\n" +
            "  \"results\": {\n" +
            "    \"filter\": [{\"id\":0, \"count\":129, \"name\": \"Pending\"}, {\"id\":1, \"count\":13, \"name\": \"Accepted\"}, {\"id\":2, \"count\":5, \"name\": \"Shipped\"}, {\"id\":3, \"count\":15, \"name\": \"delivered\"}],\n" +
            "    \"order\": [\n" +
            "      {\n" +
            "        \"id\": 181210,\n" +
            "        \"timestamp\": \"2021-01-23T02:43:31.000Z\",\n" +
            "        \"item_count\": \"12\",\n" +
            "        \"price\": \"₹79\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181220,\n" +
            "        \"timestamp\": \"2021-01-24T01:03:31.000Z\",\n" +
            "        \"item_count\": \"5\",\n" +
            "        \"price\": \"₹159\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181230,\n" +
            "        \"timestamp\": \"2021-01-24T02:23:00.000Z\",\n" +
            "        \"item_count\": \"4\",\n" +
            "        \"price\": \"₹66\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181240,\n" +
            "        \"timestamp\": \"2021-01-25T05:34:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹120\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181250,\n" +
            "        \"timestamp\": \"2021-01-25T05:38:51.000Z\",\n" +
            "        \"item_count\": \"9\",\n" +
            "        \"price\": \"₹999\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181260,\n" +
            "        \"timestamp\": \"2021-01-25T09:30:01.000Z\",\n" +
            "        \"item_count\": \"10\",\n" +
            "        \"price\": \"₹850\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181270,\n" +
            "        \"timestamp\": \"2021-01-25T06:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹250\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181280,\n" +
            "        \"timestamp\": \"2021-01-25T09:37:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹85\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181290,\n" +
            "        \"timestamp\": \"2021-01-25T03:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹150\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 0,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181211,\n" +
            "        \"timestamp\": \"2021-01-23T02:43:31.000Z\",\n" +
            "        \"item_count\": \"12\",\n" +
            "        \"price\": \"₹79\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181221,\n" +
            "        \"timestamp\": \"2021-01-24T01:03:31.000Z\",\n" +
            "        \"item_count\": \"5\",\n" +
            "        \"price\": \"₹159\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181231,\n" +
            "        \"timestamp\": \"2021-01-24T02:23:00.000Z\",\n" +
            "        \"item_count\": \"4\",\n" +
            "        \"price\": \"₹66\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181241,\n" +
            "        \"timestamp\": \"2021-01-25T05:34:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹120\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181251,\n" +
            "        \"timestamp\": \"2021-01-25T05:38:51.000Z\",\n" +
            "        \"item_count\": \"9\",\n" +
            "        \"price\": \"₹999\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181261,\n" +
            "        \"timestamp\": \"2021-01-25T09:30:01.000Z\",\n" +
            "        \"item_count\": \"10\",\n" +
            "        \"price\": \"₹850\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181271,\n" +
            "        \"timestamp\": \"2021-01-25T06:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹250\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181281,\n" +
            "        \"timestamp\": \"2021-01-25T09:37:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹85\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181291,\n" +
            "        \"timestamp\": \"2021-01-25T03:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹150\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 1,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181212,\n" +
            "        \"timestamp\": \"2021-01-23T02:43:31.000Z\",\n" +
            "        \"item_count\": \"12\",\n" +
            "        \"price\": \"₹79\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181222,\n" +
            "        \"timestamp\": \"2021-01-24T01:03:31.000Z\",\n" +
            "        \"item_count\": \"5\",\n" +
            "        \"price\": \"₹159\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181232,\n" +
            "        \"timestamp\": \"2021-01-24T02:23:00.000Z\",\n" +
            "        \"item_count\": \"4\",\n" +
            "        \"price\": \"₹66\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181242,\n" +
            "        \"timestamp\": \"2021-01-25T05:34:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹120\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181252,\n" +
            "        \"timestamp\": \"2021-01-25T05:38:51.000Z\",\n" +
            "        \"item_count\": \"9\",\n" +
            "        \"price\": \"₹999\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181262,\n" +
            "        \"timestamp\": \"2021-01-25T09:30:01.000Z\",\n" +
            "        \"item_count\": \"10\",\n" +
            "        \"price\": \"₹850\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181272,\n" +
            "        \"timestamp\": \"2021-01-25T06:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹250\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181282,\n" +
            "        \"timestamp\": \"2021-01-25T09:37:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹85\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181292,\n" +
            "        \"timestamp\": \"2021-01-25T03:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹150\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 2,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181213,\n" +
            "        \"timestamp\": \"2021-01-23T02:43:31.000Z\",\n" +
            "        \"item_count\": \"12\",\n" +
            "        \"price\": \"₹79\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181223,\n" +
            "        \"timestamp\": \"2021-01-24T01:03:31.000Z\",\n" +
            "        \"item_count\": \"5\",\n" +
            "        \"price\": \"₹159\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181233,\n" +
            "        \"timestamp\": \"2021-01-24T02:23:00.000Z\",\n" +
            "        \"item_count\": \"4\",\n" +
            "        \"price\": \"₹66\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181243,\n" +
            "        \"timestamp\": \"2021-01-25T05:34:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹120\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181253,\n" +
            "        \"timestamp\": \"2021-01-25T05:38:51.000Z\",\n" +
            "        \"item_count\": \"9\",\n" +
            "        \"price\": \"₹999\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181263,\n" +
            "        \"timestamp\": \"2021-01-25T09:30:01.000Z\",\n" +
            "        \"item_count\": \"10\",\n" +
            "        \"price\": \"₹850\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181273,\n" +
            "        \"timestamp\": \"2021-01-25T06:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹250\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181283,\n" +
            "        \"timestamp\": \"2021-01-25T09:37:01.000Z\",\n" +
            "        \"item_count\": \"1\",\n" +
            "        \"price\": \"₹85\",\n" +
            "        \"status\": \"COD\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": false,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 181293,\n" +
            "        \"timestamp\": \"2021-01-25T03:38:51.000Z\",\n" +
            "        \"item_count\": \"2\",\n" +
            "        \"price\": \"₹150\",\n" +
            "        \"status\": \"paid\",\n" +
            "        \"type\": 3,\n" +
            "        \"is_new\": true,\n" +
            "        \"thumbnail\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}\n" +
            "\n";

    private FilterAdapter mFilterAdapter;
    private OrderAdapter mOrderAdapter;



    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        // Inflate the layout for this fragment
        RecyclerView filterRecyclerView = rootView.findViewById(R.id.filter_recyclerview);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        filterRecyclerView.setLayoutManager(mLayoutManager);

        mFilterAdapter = new FilterAdapter((ArrayList<Filter>) QueryUtils.extractFilterJson(mJsonData));
        filterRecyclerView.setAdapter(mFilterAdapter);

        mOrderAdapter = new OrderAdapter(getActivity(), new ArrayList<Order>());

        ListView orderListView = (ListView) rootView.findViewById(R.id.order_listview);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        mOrderAdapter = new OrderAdapter(getActivity(),(ArrayList<Order>) QueryUtils.extractOrderJson(mJsonData));
        orderListView.setAdapter(mOrderAdapter);

        LoaderManager.getInstance(this).initLoader(1, null, this);
        Helper.getListViewSize(orderListView);

        return rootView;
    }


    @NonNull
    @Override
    public Loader<List<Order>> onCreateLoader(int id, @Nullable Bundle args) {
        return new OrderLoader(getActivity(), mJsonData);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<List<Order>> loader, List<Order> orders) {
        mOrderAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (orders != null && !orders.isEmpty()) {
            mOrderAdapter.addAll(orders);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<Order>> loader) {
        mOrderAdapter.clear();
    }
}