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

package com.hoverdroids.gridviews.viewmodel;

/**
 * Model for updating a ViewGroup containing one TextView and one ImageView.
 * This is useful given the number of instances used in most apps.
 * e.g. spinners, dropdowns, profiles, etc.
 */
public class ImageTextModelImp extends ViewGroupModelImp
{
    /**
     * Constructor - with minimum arguments.
     * @param layoutResourceId The layout resource ID
     * @param id The view ID corresponding to this viewModel
     */
    public ImageTextModelImp(final int layoutResourceId, final int id) {
        super(layoutResourceId, id);
    }

    /**
     * Constructor for quickly creating a viewModel when only one ImageView and TextView are used in the layout.
     * @param layoutResourceId The layoutResourceId
     * @param id The view ID corresponding to this viewModel
     * @param textViewId The textViewId
     * @param text The text
     * @param imageViewId The imageViewId
     * @param imageResourceId The imageResourceId
     */
    public ImageTextModelImp(final int layoutResourceId, final int id, final int textViewId, final String text,
                             final int imageViewId, final int imageResourceId){
        super(layoutResourceId, id);
        setChildViewModel(new TextViewModelImp(textViewId, text));
        setChildViewModel(new ImageViewModelImp(imageViewId, imageResourceId));
    }

    /**
     * Constructor for quickly creating a viewModel when only one TextView is used in the layout.
     * @param layoutResourceId The layoutResourceId
     * @param id The view ID corresponding to this viewModel
     * @param textViewId The textViewId
     * @param text The text
     */
    public ImageTextModelImp(final int layoutResourceId, final int id, final int textViewId, final String text){
        super(layoutResourceId, id);
        setChildViewModel(new TextViewModelImp(textViewId, text));
    }

    /**
     * Constructor for quickly creating an viewModel when only one ImageView is used in the layout.
     * @param layoutResourceId The layoutResourceId
     * @param id The view ID corresponding to this viewModel
     * @param imageViewId The imageViewId
     * @param imageResourceId The imageResourceId
     */
    public ImageTextModelImp(final int layoutResourceId, final int id, final int imageViewId, final int imageResourceId){
        super(layoutResourceId, id);
        setChildViewModel(new ImageViewModelImp(imageViewId, imageResourceId));
    }
}
