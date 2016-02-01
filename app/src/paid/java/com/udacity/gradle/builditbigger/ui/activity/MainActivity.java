package com.udacity.gradle.builditbigger.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.joketime.android.JokeShowActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.network.LoadJokeTask;

public class MainActivity extends ActionBarActivity
{
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        showJoke();
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
                    if(joke != null)
                    {
                        JokeShowActivity.showJoke(joke, getApplicationContext());
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
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
