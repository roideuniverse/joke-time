package com.udacity.gradle.builditbigger.util;

import com.udacity.gradle.builditbigger.BuildConfig;

/**
 * Created by roide on 1/31/16.
 */
public final class Util
{
    public static boolean checkIsFreeFlavor()
    {
        return BuildConfig.FLAVOR.equals("free");
    }
}
