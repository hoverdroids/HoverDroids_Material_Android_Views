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

package com.hoverdroids.view.viewmodel;

import com.hoverdroids.viewmodel.model.ViewModelImp;

/** Implementation of TextViewModel. */
public class TextViewModelImp extends ViewModelImp implements TextViewModel {

    private String text;
    private int textColor = INVALID_COLOR;

    /**
     * Constructor. Use this when the viewModel's view is the top-level parent.
     * @param layoutResourceId The layout resource ID
     * @param viewId The view ID corresponding to this viewModel
     * @param text The text
     */
    public TextViewModelImp(final int layoutResourceId, final int viewId, final String text) {
        super(layoutResourceId, viewId);
        this.text = text;
    }

    /**
     * Constructor. Use this when the viewModel's view is a child since only the top-level parent's layoutResId is used.
     * @param viewId The view ID corresponding to this viewModel
     * @param text The text
     */
    public TextViewModelImp(final int viewId, final String text) {
        super(viewId);
        this.text = text;
    }

    /**
     * Get the text.
     * @return The text
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * Set the text.
     * @param text The text
     */
    @Override
    public void setText(final String text) {
        this.text = text;
    }

    /**
     * Get the text color
     * @return The color
     */
    @Override
    public int getTextColor() {
        return textColor;
    }

    /**
     * Set the text color.
     * @param color The color
     */
    @Override
    public void setTextColor(final int color) {
        this.textColor = color;
    }
}
