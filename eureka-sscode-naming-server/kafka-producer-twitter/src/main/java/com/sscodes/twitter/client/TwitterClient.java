package com.sscodes.twitter.client;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ssharma6757 on 1/15/2020.
 */
@Component
public class TwitterClient {

    public ClientBuilder getTwitterClient() {

        /** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
        BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>(1000);

/** Declare the host you want to connect to, the endpoint, and authentication (basic auth or oauth) */
        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
// Optional: set up some followings and track terms
        List<Long> followings = Lists.newArrayList(1234L, 566788L);
        List<String> terms = Lists.newArrayList("twitter", "api");
        hosebirdEndpoint.followings(followings);
        hosebirdEndpoint.trackTerms(terms);

// These secrets should be read from a config file
        Authentication hosebirdAuth = new OAuth1("msutXqvZ1QJlDGpHYBf2u2uMz",
                "NXNKlCE4vaNFO30c2TXbVXreGwTDPQS6QH8cUWrC8Aqe3Xsx9T",
                "1158074588992905216-i3AcbIaLUODb46Hhd2jUW6oUGzwZe8",
                "wCjRgPu1FBv2TXMsgw64brAhTgmBGdqA5lGJiFkQlW41X");

        ClientBuilder builder = new ClientBuilder()
                .name("kafka-app-learning")                              // optional: mainly for the logs
                .hosts(hosebirdHosts)
                .authentication(hosebirdAuth)
                .endpoint(hosebirdEndpoint)
                .eventMessageQueue(eventQueue);                          // optional: use this if you want to process client events
        return builder;
    }
}
