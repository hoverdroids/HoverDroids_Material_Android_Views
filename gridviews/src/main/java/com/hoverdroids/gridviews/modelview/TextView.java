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

package com.hoverdroids.gridviews.modelview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.hoverdroids.gridviews.util.ViewUtils;
import com.hoverdroids.gridviews.viewmodel.TextViewModel;
import com.hoverdroids.gridviews.viewmodel.ViewModel;

public class TextView extends AppCompatTextView implements ModelView {

    public TextView(final Context context) {
        super(context);
    }

    public TextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public TextView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Set viewModel.
     * If the viewModel implements AdapterModel, and this view is being shown in an AdapterView, then this is a good place to modify
     * views based on the model position, is isFirst, and isLast. For example, alternate row views so every other row looks different,
     * display the first row as a header, and display last row as a footer.
     * @param viewModel The viewModel
     */
    @Override
    public void setViewModel(final ViewModel viewModel) {
        //Set attrs specific to a View
        ViewUtils.setBackgroundColor(this, viewModel);

        if (viewModel instanceof TextViewModel) {
            //Set the attrs specific to ImageView
            final TextViewModel tvItem = (TextViewModel) viewModel;
            ViewUtils.setText(this, tvItem);
        }
    }
}
