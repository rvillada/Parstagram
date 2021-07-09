package com.codepath.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("DKSrpzMV8Slu4ivmw3D5mB4tnNCwXheh4nsGQ2IY")
                .clientKey("L84aQSvnFTzGQkOkg4E5TQqHGwVdch6WmMhfj8D1")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
