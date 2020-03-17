package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {


    public MasterListFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView=(GridView) rootView.findViewById(R.id.images_grid_view);

        gridView.setAdapter(new MasterListAdapter(rootView.getContext(),AndroidImageAssets.getAll()));
        return rootView;

    }
}
