ChatParse
=========
ChatParse is written in Java as a command line application.

Requirements
-------------------
* Java 7

Dependencies
-------------------
* [Gson](https://code.google.com/p/google-gson/)

Output
---------
    Input: "@chris you around?"
    Output:
    {
      "mentions": [
        "chris"
      ]
    }
    Input: "Good morning! (megusta) (coffee)"
    Output:
    {
      "emoticons": [
        "megusta",
        "coffee"
      ]
    }
    Input: "Olympics are starting soon; http://www.nbcolympics.com"
    Output:
    {
      "links": [
        {
          "url": "http://www.nbcolympics.com",
          "title": "NBC Olympics | Home of the 2016 Olympic Games in Rio"
        }
      ]
    }
    Input: "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016"
    Output:
    {
      "mentions": [
        "bob",
        "john"
      ],
      "emoticons": [
        "success"
      ],
      "links": [
        {
          "url": "https://twitter.com/jdorfman/status/430511497475670016",
          "title": "Justin Dorfman on Twitter: \u0026quot;nice @littlebigdetail from @HipChat (shows hex colors when pasted in chat). http://t.co/7cI6Gjy5pq\u0026quot;"
        }
      ]
    }
    Input: "@Chris Good morning! chris@gmail.com (megusta) (coffee) (thisemoticonistoolong) https://www.hipchat.com/downloads - ww.notvalid.com - www.internet.com"
    Output:
    {
      "mentions": [
        "Chris"
      ],
      "emoticons": [
        "megusta",
        "coffee"
      ],
      "links": [
        {
          "url": "https://www.hipchat.com/downloads",
          "title": "HipChat - Downloads"
        },
        {
          "url": "http://www.internet.com",
          "title": " Internet.com \u0026#8211; Internet News, Domain Names, Domain Hosting, Free Email and more"
        }
      ]
    }
