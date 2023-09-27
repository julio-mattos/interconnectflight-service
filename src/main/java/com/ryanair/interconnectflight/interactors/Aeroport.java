package com.ryanair.interconnectflight.interactors;

import com.ryanair.interconnectflight.clients.response.RoutesResponse;

@FunctionalInterface
public interface Aeroport {

    boolean filter(RoutesResponse response, String from, String to);
}
