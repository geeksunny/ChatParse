package com.radicalninja.chatparse;

import com.google.gson.annotations.Expose;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Link {

    @Expose
    private String url;

    @Expose
    private String title;

    public static Link fromUrl(String url) {
        try {
            if (url.startsWith("www")) {
                url = "http://"+url;
            }
            return new Link(url, Link.getPageTitle(new URL(url)));
        } catch (MalformedURLException e) {
            Main.log("URL is malformed! ("+url+")");
        } catch (IOException e) {
            Main.log("Error opening URL! ("+url+")");
        }
        return null;
    }

    public Link() { }

    public Link(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private static String getPageTitle(URL url) throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        Pattern pHead = Pattern.compile("(?i)</HEAD>");
        Matcher mHead;
        Pattern pTitle = Pattern.compile("(?i)</TITLE>");
        Matcher mTitle;

        String inputLine;
        boolean found = false;
        boolean notFound = false;
        String html = "";
        String title = "";

        while (!(((inputLine = in.readLine()) == null) || found || notFound)) {
            html = html + inputLine;
            mHead = pHead.matcher(inputLine);
            if (mHead.find()) {
                notFound = true;
            } else {
                mTitle = pTitle.matcher(inputLine);
                if (mTitle.find()) {
                    found = true;
                }
            }
        }
        in.close();

        html = html.replaceAll("\\s+", " ");
        if (found) {
            Pattern p = Pattern.compile("(?i)<TITLE.*?>(.*?)</TITLE>");
            Matcher m = p.matcher(html);
            while (m.find()) {
                title = m.group(1);
            }
        }

        return title;
    }
}
