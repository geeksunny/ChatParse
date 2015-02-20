package com.radicalninja.chatparse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

        String testStrings[] = {
                "@chris you around?",
                "Good morning! (megusta) (coffee)",
                "Olympics are starting soon; http://www.nbcolympics.com",
                "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016",
                "@Chris Good morning! chris@gmail.com (megusta) (coffee) (thisemoticonistoolong) https://www.hipchat.com/downloads - ww.notvalid.com - www.internet.com"
        };

        Main.process(testStrings);
    }

    public static void process(String[] messages) {
        ChatParser parser = new ChatParser();

        for (String msg : messages) {
            Main.log(String.format("Input: \"%s\"", msg));
            Main.log(String.format("Output:\n%s", parser.parse(msg).toString()));
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
