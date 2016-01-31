package com.udacity.gradle.builditbigger.ui.network;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by roide on 1/31/16.
 */
public class LoadJokeTask extends AsyncTask<Void, Void, String>
{
    private OnJokeLoadedCallback mOnJokeLoadedCallbackCallback;

    public LoadJokeTask(OnJokeLoadedCallback callback)
    {
        mOnJokeLoadedCallbackCallback = callback;
    }

    @Override
    protected String doInBackground(Void... params)
    {
        try
        {
            String joke = Api.get().getJoke().execute().getJoke();
            return joke;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if(mOnJokeLoadedCallbackCallback != null)
        {
            mOnJokeLoadedCallbackCallback.onJokeLoaded(s);
        }

    }

    public interface OnJokeLoadedCallback
    {
        void onJokeLoaded(String joke);
    }
}
