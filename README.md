#android-nanodegree-project #4 Joke Time

## Project Overview
In this project, you will create an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app will consist of four modules:

1. A Java library that provides jokes
2. A Google Cloud Endpoints (GCE) project that serves those jokes
3. An Android Library containing an activity for displaying jokes
4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display

##Why this Project?

As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.

##Architecture
![Archotecture](https://cloud.githubusercontent.com/assets/233539/18254296/53e579c8-736a-11e6-98ad-46652da444bf.png)

##Requirements

1. Add free and paid flavors to an app, and set up your build to share code between them
2. Factor reusable functionality into a Java library
3. Factor reusable Android functionality into an Android library
4. Configure a multi-project build to compile your libraries and app
5. Use the Gradle App Engine plugin to deploy a backend
6. Configure an integration test suite that runs against the local App Engine development server
7. Configure Test Task, To tie it all together, create a Gradle task that:
  * Launches the GCE local development server
  * Runs all tests
  * Shuts the server down again
  
#Result
![App gif](https://cloud.githubusercontent.com/assets/233539/18254371/0fdacdcc-736b-11e6-8f2d-d82908444020.gif)


