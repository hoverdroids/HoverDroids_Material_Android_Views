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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** Implementation of ViewGroupModel. */
public class ViewGroupModelImp extends ViewModelImp implements ViewGroupModel {

    private Map<Integer, ViewModel> viewModels = new HashMap<>();

    /**
     * Constructor.
     * @param layoutResourceId The layout resource ID
     * @param id The view ID corresponding to this model
     */
    public ViewGroupModelImp(final int layoutResourceId, final int id) {
        super(layoutResourceId, id);
    }

    /**
     * Get the viewModel for the view with the given ID.
     * @param id The view's ID
     * @return The viewModel
     */
    @Override
    public ViewModel getChildViewModel(final int id) {
        return viewModels.get(id);
    }

    /**
     * Get all of the viewModels.
     * @return The child viewModels
     */
    @Override
    public Map<Integer, ViewModel> getChildViewModels() {
        return viewModels;
    }

    /**
     * Set all of the viewModels
     * @param viewModels The child view models.
     */
    @Override
    public void setChildViewModels(final Map<Integer, ViewModel> viewModels) {
        this.viewModels = viewModels;
    }

    @Override
    public void setIsFirst(boolean isFirst) {
        super.setIsFirst(isFirst);

        //The children views might also want to know their relative placement in an adapter. If so, they need to implement AdapterModel too.
        final Iterator it = viewModels.keySet().iterator();
        while (it.hasNext()) {
            final ViewModel viewModel = viewModels.get(it.next());
            if (viewModel instanceof AdapterModel) {
                ((AdapterModel)viewModel).setIsFirst(isFirst);
            }
        }
    }

    @Override
    public void setIsLast(boolean isLast) {
        super.setIsLast(isLast);

        //The children views might also want to know their relative placement in an adapter. If so, they need to implement AdapterModel too.
        final Iterator it = viewModels.keySet().iterator();
        while (it.hasNext()) {
            final ViewModel viewModel = viewModels.get(it.next());
            if (viewModel instanceof AdapterModel) {
                ((AdapterModel)viewModel).setIsLast(isLast);
            }
        }
    }

    @Override
    public void setPosition(int position) {
        super.setPosition(position);

        //The children views might also want to know their relative placement in an adapter. If so, they need to implement AdapterModel too.
        final Iterator it = viewModels.keySet().iterator();
        while (it.hasNext()) {
            final ViewModel viewModel = viewModels.get(it.next());
            if (viewModel instanceof AdapterModel) {
                ((AdapterModel)viewModel).setPosition(position);
            }
        }
    }
}
