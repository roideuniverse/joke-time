package roide.joketime.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.joketimelib.JokeTime;

import javax.inject.Named;

/**
 * Created by roide on 1/31/16.
 */
@Api(
        name = "jokeTimeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joketime.roide",
                ownerName = "backend.joketime.roide",
                packagePath = ""
        )
)
public class JokeTimeEndpoint
{
    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name)
    {
        MyBean response = new MyBean();
        response.setData("Hello " + name);
        return response;
    }

    @ApiMethod(name = "getJoke", httpMethod = ApiMethod.HttpMethod.GET, path = "getJoke")
    public JokeBean getJoke()
    {
        JokeBean response = new JokeBean();
        response.setJoke(JokeTime.loadJoke());
        return response;
    }
}
