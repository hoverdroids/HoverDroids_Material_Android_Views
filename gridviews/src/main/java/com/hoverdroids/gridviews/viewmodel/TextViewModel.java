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

/** Model for updating a TextView. */
public interface TextViewModel extends ViewModel
{
    /**
     * Get the text.
     * @return The text
     */
    String getText();

    /**
     * Set the text.
     * @param text The text
     */
    void setText(final String text);

    /**
     * Get the text color.
     * @return The text color
     */
    default int getTextColor(){
        return Integer.MIN_VALUE;
    }

    /**
     * Set the text color.
     * @param color The color
     */
    void setTextColor(final int color);
}
