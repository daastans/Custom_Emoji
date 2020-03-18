package com.example.android.android_me.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {
    public MasterListFragment() {
    }

    OnImageClickListener callback;

    public void setOnImageClickListener(OnImageClickListener callback) {
        this.callback = callback;
    }

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        try {
            callback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "Must implement OnImageClickListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle
            savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        gridView.setAdapter(new MasterListAdapter(rootView.getContext(), AndroidImageAssets.getAll()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long l) {
                callback.onImageSelected(positon);
            }
        });


        return rootView;

    }


}