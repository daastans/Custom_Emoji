package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class FragmentBodyPart extends Fragment {
    public FragmentBodyPart() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);
        ImageView imageView=(ImageView) rootView.findViewById(R.id.fragment_body_part_imageview);
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return  rootView;

    }
}
