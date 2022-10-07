/*
 * Copyright (C) 2022 elytraOS
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class ElytraVersionPreferenceController extends BasePreferenceController {

    private static final String ELYTRA_CODENAME_PROP = "ro.elytra.codename";
    private static final String ELYTRA_BUILDTYPE_PROP = "ro.elytra.build.type";
    private static final String ELYTRA_VARIANT_PROP = "ro.elytra.build.variant";

    private final Context mContext;

    public ElytraVersionPreferenceController(Context context, String key) {
        super(context, key);
        mContext = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE_UNSEARCHABLE;
    }

    @Override
    public CharSequence getSummary() {
        String version = SystemProperties.get(ELYTRA_CODENAME_PROP,
                mContext.getString(R.string.device_info_default));
        String buildType = SystemProperties.get(ELYTRA_BUILDTYPE_PROP,
                mContext.getString(R.string.device_info_default));
        String variant = SystemProperties.get(ELYTRA_VARIANT_PROP,
                mContext.getString(R.string.device_info_default));

        // Example: 13.0 | OFFICIAL | GAPPS
        return version + " | " + buildType + " | " + variant;
    }
}
