/*
 * Copyright (C) 2012 - 2019. HoverDroids and Christopher Sprague
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hoverdroids.hoverdroids_android_views_and_widgets;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.hoverdroids.adapterview.modelview.ViewModelAdapter;
import com.hoverdroids.adapterview.view.TouchSyncTwoWayGridView;
import com.hoverdroids.touchsync.OnSourceTouchEventListener;
import com.hoverdroids.modelviewgroup.viewmodel.ImageTextViewGroupModelImp;
import com.hoverdroids.viewmodel.model.AdapterModel;
import com.hoverdroids.viewmodel.model.ViewModelImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SynchronizedGridViewsActivity extends AppCompatActivity implements OnSourceTouchEventListener
{
    @BindView(R.id.topGridView)
    TouchSyncTwoWayGridView topGridView;

    @BindView(R.id.centerGridView)
    TouchSyncTwoWayGridView centerGridView;

    @BindView(R.id.bottomGridView)
    TouchSyncTwoWayGridView bottomGridView;

    private ViewModelAdapter topAdapter;
    private ViewModelAdapter centerAdapter;
    private ViewModelAdapter bottomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.synchronized_gridviews);
        
        ButterKnife.bind(this);
        
        topAdapter = new ViewModelAdapter(getApplicationContext(), getImageTextItems());
        topGridView.setAdapter(topAdapter);
        topGridView.setOnSourceTouchEventListener(this);
        topGridView.setRelativePosition(5,-30);

        centerAdapter = new ViewModelAdapter(getApplicationContext(), getImageTextItems());
        centerGridView.setAdapter(centerAdapter);
        centerGridView.setOnSourceTouchEventListener(this);
        centerGridView.setRelativePosition(5,-30);

        bottomAdapter = new ViewModelAdapter(getApplicationContext(), getImageTextItems());
        bottomGridView.setAdapter(bottomAdapter);
        bottomGridView.setOnSourceTouchEventListener(this);
        bottomGridView.setRelativePosition(5,-30);
    }

    @Override
    public void onSourceTouchEvent(View sourceView, MotionEvent ev) {
        topGridView.onTouchEvent(sourceView, ev);
        centerGridView.onTouchEvent(sourceView, ev);
        bottomGridView.onTouchEvent(sourceView, ev);
    }

    /**
     * Get an example list of items with ImageView and TextView data.
     * @return The items
     */
    private List<AdapterModel> getImageTextItems() {
        final int[] layouts = {R.layout.image_text_item_view, R.layout.text_image_item_view};

        final List<AdapterModel> items = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            final int layout = layouts[i%2];
            final ImageTextViewGroupModelImp item
                    = new ImageTextViewGroupModelImp(layout, R.id.container,
                    R.id.text_view_1, "My name is " + i,
                    R.id.image_view_1, R.drawable.ic_launcher_background);

            items.add(item);
        }
        return items;
    }

    private List<AdapterModel> getColorItems() {
        final Random rnd = new Random();

        final List<AdapterModel> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

            //ID does not have to be set for the top-most parent since it's assumed
            final ViewModelImp item = new ViewModelImp("com.hoverdroids.gridviews.itemview.ImageView", -1);
            item.setBackgroundColor(color);
            items.add(item);
        }

        return items;
    }
}
