/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.accessibility;

import android.content.Context;

import com.android.settings.core.BasePreferenceController;

/** Controller that shows the magnification area mode summary. */
public class MagnificationModePreferenceController extends BasePreferenceController {

    public MagnificationModePreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }


    @Override
    public CharSequence getSummary() {
        final int capabilities = MagnificationCapabilities.getCapabilities(mContext);
        return MagnificationCapabilities.getSummary(mContext, capabilities);
    }
}
