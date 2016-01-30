package com.joketimelib;

import java.util.concurrent.Callable;

/**
 * Created by roide on 1/28/16.
 */
public class JokeLoadTask implements Callable<String>
{
    private static int count = 0;
    private JokeLoadCallback mCallback;

    public JokeLoadTask()
    {
        //Empty constructor, do nothing
    }

    public JokeLoadTask(JokeLoadCallback callback)
    {
        mCallback = callback;
    }

    private String getJoke()
    {
        return "Joke:" + count++;
    }

    @Override
    public String call()
    {
        if(mCallback != null)
        {
            mCallback.onJokeLoaded(getJoke());
        }
        return getJoke();
    }
}
