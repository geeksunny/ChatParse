package com.radicalninja.chatparse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatParser {

    private static final String PATTERN =
            "(?<mentions>\\B@[a-zA-Z]+)|(?<emoticons>\\([a-zA-Z]{1,15}\\))|(?<links>(?:http[s]?:[/]{2}|www.)(?:[a-zA-Z0-9/.~])+)";

    private Pattern mPattern = Pattern.compile(PATTERN);

    public ChatParser() { }

    public ChatContents parse(String msg) {

        ChatContents contents = new ChatContents();

        Matcher matcher = mPattern.matcher(msg);
        String match;
        while (matcher.find()) {
            match = matcher.group();

            if (matcher.group("mentions") != null) {
                contents.addMention(match);
            } else if (matcher.group("emoticons") != null) {
                contents.addEmoticon(match);
            } else if (matcher.group("links") != null) {
                Link link = Link.fromUrl(match);
                if (link != null) {
                    contents.addLink(link);
                }
            }
        }

        return contents;
    }

}
