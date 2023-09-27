package com.ryanair.interconnectflight.interactors.impl;

import com.ryanair.interconnectflight.clients.ApiRoutes;
import com.ryanair.interconnectflight.clients.response.RoutesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoutesUseCaseImpl {

    private final ApiRoutes apiRoutes;

    public List<RoutesResponse> getRoutes(String airportFrom, String airportTo){
        return apiRoutes.getRoutes().stream()
                .filter(r -> r.getConnectingAirport() == null && r.getOperator().equals("RAYNAIR"))
                .collect(Collectors.toList());
    }
}
