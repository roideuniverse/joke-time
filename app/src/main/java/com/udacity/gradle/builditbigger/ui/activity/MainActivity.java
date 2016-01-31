package com.udacity.gradle.builditbigger.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.joketime.android.JokeShowActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.network.LoadJokeTask;
import com.udacity.gradle.builditbigger.util.Util;


public class MainActivity extends ActionBarActivity
{
    private InterstitialAd mInterstitialAd;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareInterstitial();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(final View view)
    {
        if(Util.checkIsFreeFlavor())
        {
            if(mInterstitialAd.isLoaded())
            {
                mInterstitialAd.show();
            }
            else
            {
                showJoke();
            }
        }
        else
        {
            showJoke();
        }
    }

    private void prepareInterstitial()
    {
        if(Util.checkIsFreeFlavor())
        {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            mInterstitialAd.setAdListener(new AdListener()
            {
                @Override
                public void onAdClosed()
                {
                    super.onAdClosed();
                    showJoke();
                    requestInterstitial();
                }
            });
            requestInterstitial();
        }
    }

    private void requestInterstitial()
    {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void showJoke()
    {
        showProgressBar(true);
        new LoadJokeTask(new LoadJokeTask.OnJokeLoadedCallback()
        {
            @Override
            public void onJokeLoaded(String joke)
            {
                if(! MainActivity.this.isFinishing())
                {
                    showProgressBar(false);
                    JokeShowActivity.showJoke(joke, getApplicationContext());
                }
            }
        }).execute();
    }

    private void showProgressBar(final boolean show)
    {
        if(mProgressBar == null)
        {
            mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        }
        mProgressBar.post(new Runnable()
        {
            @Override
            public void run()
            {
                if(show)
                {
                    mProgressBar.setVisibility(View.VISIBLE);
                }
                else
                {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
