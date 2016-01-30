package com.joketime.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeShowActivity extends AppCompatActivity
{
    public static final String ARG_JOKE = "arg-joke";
    private String mJoke;

    public static void showJoke(String joke, Context context)
    {
        Intent i = new Intent(context, JokeShowActivity.class);
        i.putExtra(ARG_JOKE, joke);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_show);
        readIntent();
        prepareView();
    }

    private void prepareView()
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Joke Time");
        ((TextView)findViewById(R.id.jokeTextView)).setText(mJoke);
    }

    private void readIntent()
    {
        if(getIntent() != null && getIntent().hasExtra(ARG_JOKE))
        {
            mJoke = getIntent().getStringExtra(ARG_JOKE);
        }
        else
        {
            throw new IllegalStateException("Set the Joke using the intent argument");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
