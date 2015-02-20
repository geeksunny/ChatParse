package com.radicalninja.chatparse;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class ChatContents {

    @Expose
    private List<String> mentions;

    @Expose
    private List<String> emoticons;

    @Expose
    private List<Link> links;

    public ChatContents() { }

    public List<String> getMentions() {
        return mentions;
    }

    public void setMentions(List<String> mentions) {
        this.mentions = mentions;
    }

    public void addMention(String mention) {
        if (mentions == null) {
            mentions = new ArrayList<String>();
        }
        mentions.add(mention);
    }

    public List<String> getEmoticons() {
        return emoticons;
    }

    public void setEmoticons(List<String> emoticons) {
        this.emoticons = emoticons;
    }

    public void addEmoticon(String emoticon) {
        if (emoticons == null) {
            emoticons = new ArrayList<String>();
        }
        emoticons.add(emoticon);
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(Link link) {
        if (links == null) {
            links = new ArrayList<Link>();
        }
        links.add(link);
    }

    @Override
    public String toString() {
        return Main.gson.toJson(this);
    }
}
