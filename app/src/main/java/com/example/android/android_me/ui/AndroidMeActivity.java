/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.io.FileDescriptor;
import java.io.PrintWriter;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        int bodyIndex=getIntent().getIntExtra("BODY_INDEX",0);
        int headIndex=getIntent().getIntExtra("HEAD_INDEX",0);
        int legIndex=getIntent().getIntExtra("LEG_INDEX",0);




        if(savedInstanceState==null) {

            FragmentBodyPart headFragment = new FragmentBodyPart();
            headFragment.setmImageIds(AndroidImageAssets.getHeads());
            headFragment.setmListIndex(headIndex);

            FragmentBodyPart bodyFragment = new FragmentBodyPart();
            bodyFragment.setmImageIds((AndroidImageAssets.getBodies()));
            bodyFragment.setmListIndex(bodyIndex);

            FragmentBodyPart legFragment = new FragmentBodyPart();
            legFragment.setmImageIds((AndroidImageAssets.getLegs()));
            legFragment.setmListIndex(legIndex);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().add(R.id.head_container, headFragment).commit();
            fragmentManager.beginTransaction().add(R.id.body_container, bodyFragment).commit();
            fragmentManager.beginTransaction().add(R.id.leg_container, legFragment).commit();

        }
    }
}
