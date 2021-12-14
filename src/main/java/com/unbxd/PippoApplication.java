package com.unbxd;

import com.unbxd.controllers.MoviesController;

import ro.pippo.controller.ControllerApplication;

/**
 * A simple Pippo application.
 *
 * @see com.unbxd.PippoLauncher#main(String[])
 */
public class PippoApplication extends ControllerApplication {


    @Override
    protected void onInit() {
        getRouter().ignorePaths("/favicon.ico");
        GET("/", routeContext -> routeContext.send("Hello World"));
        addControllers(MoviesController.class);
    }

}
