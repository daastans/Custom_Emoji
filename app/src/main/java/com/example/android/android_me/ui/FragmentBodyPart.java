package com.example.android.android_me.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class FragmentBodyPart extends Fragment {

    private final String LOG_TAG="FragmentBodyPart";
    private List<Integer> mImageIds;

    private int mListIndex;
    public FragmentBodyPart() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_body_part,container,false);
        final ImageView imageView=(ImageView) rootView.findViewById(R.id.fragment_body_part_imageview);

        if(mImageIds!=null) {
            imageView.setImageResource(mImageIds.get(mListIndex));

        }
        else Log.e(LOG_TAG,"Invalid Image ids");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListIndex++;
                if(mListIndex>mImageIds.size()-1) mListIndex=0;
                imageView.setImageResource(mImageIds.get(mListIndex));
            }
        });

        return  rootView;
    }
    public void setmImageIds(List<Integer> imageIds){
        mImageIds=imageIds;
    }
    public void setmListIndex(int index){
        mListIndex=index;
    }
}
