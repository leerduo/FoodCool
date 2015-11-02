package com.bohe.foodcool.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bohe.foodcool.R;
import com.bohe.foodcool.adapters.MyRecyclerViewAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mainfragment extends Fragment {

    public Mainfragment() {

    }

    List<Integer> datas ;

    private MyRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        datas = new LinkedList<>();

        for (int i = 0; i < 8; i++) {
            datas.add(i);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.main_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) ret.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyRecyclerViewAdapter(getContext(),datas);

        recyclerView.setAdapter(adapter);

        return ret;
    }

}
