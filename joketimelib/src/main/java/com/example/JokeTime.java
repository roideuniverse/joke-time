package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JokeTime
{
    private static JokeTime mJokeTime;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(3);

    private JokeTime()
    {
        //Private constructor
    }

    private static JokeTime getInstance()
    {
        if(mJokeTime == null)
        {
            mJokeTime = new JokeTime();
        }
        return mJokeTime;
    }

    /**
     *
     * @return A Synchronous method to get a joke
     */
    public static String loadJoke()
    {
        return new JokeLoadTask().call();
    }

    /**
     * This code gets the joke from the server in a different thread.
     * @param jokeLoadCallback The callback that will be called when the joke is loaded.
     */
    public static void loadJoke(JokeLoadCallback jokeLoadCallback)
    {
        JokeLoadTask task = new JokeLoadTask(jokeLoadCallback);
        getInstance().mExecutorService.submit(task);
    }
}
