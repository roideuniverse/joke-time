package com.udacity.gradle.builditbigger.network;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by roide on 1/31/16.
 */
public class LoadJokeTaskTest extends AndroidTestCase
{
    public void testJokeFetch() throws ExecutionException, InterruptedException
    {
        String joke = new LoadJokeTask(null).execute().get();
        assertTrue(joke != null && !joke.isEmpty());
    }
}
