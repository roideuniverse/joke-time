package com.udacity.gradle.builditbigger.network;

import android.test.AndroidTestCase;
import android.test.suitebuilder.annotation.SmallTest;

import java.util.concurrent.ExecutionException;

/**
 * Created by roide on 1/31/16.
 */
public class LoadJokeTaskAndroidTest extends AndroidTestCase
{
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    @SmallTest
    public void testJokeFetch() throws Exception
    {
        String joke = new LoadJokeTask(null).execute().get();
        assertTrue(joke != null && !joke.isEmpty());
    }
}
