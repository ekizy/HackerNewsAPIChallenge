package de.conntac.com.hackernewsstoryoverviewapp.network;

import de.conntac.com.hackernewsstoryoverviewapp.BuildConfig;

public class NetworkHelper {

    public final static String BASE_URL = BuildConfig.BASE_URL;

    public final static String getStoryIDs = BASE_URL + "topstories.json";

    public static String getStoryDetailURL(String storyID) {
        return BASE_URL + "item/" + storyID + ".json";
    }

}
