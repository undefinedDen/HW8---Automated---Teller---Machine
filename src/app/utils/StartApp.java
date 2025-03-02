package app.utils;

import app.controller.AppController;

public class StartApp {
    public static void startApp(){
        new AppController().getOutput();
    }
}
