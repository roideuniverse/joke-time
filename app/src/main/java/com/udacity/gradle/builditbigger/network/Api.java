package com.udacity.gradle.builditbigger.network;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import roide.joketime.backend.jokeTimeApi.JokeTimeApi;

/**
 * Created by roide on 1/31/16.
 */
public class Api
{
    private static JokeTimeApi myApi;

    public static JokeTimeApi get()
    {
        if(myApi == null)
        {
            JokeTimeApi.Builder builder = new JokeTimeApi.Builder(AndroidHttp
                    .newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://nanodegreejoketime.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer()
                    {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest) throws
                                IOException
                        {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }
        return myApi;
    }
}
