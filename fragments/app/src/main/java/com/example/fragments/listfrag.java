package com.example.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listfrag newInstance} factory method to
 * create an instance of this fragment.
 */
public class listfrag extends ListFragment {


    public listfrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> data = new ArrayList<>();
        data.add("1. This s item 1");
        data.add("2. This s item 1");
        data.add("3. This s item 1");
        data.add("4. This s item 1");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_gallery_item,data));
    }







    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}