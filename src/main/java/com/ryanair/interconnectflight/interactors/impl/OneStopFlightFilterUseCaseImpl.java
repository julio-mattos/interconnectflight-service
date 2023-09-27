package com.ryanair.interconnectflight.interactors.impl;

import com.ryanair.interconnectflight.interactors.RouteFilterUseCase;
import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class OneStopFlightFilterUseCaseImpl implements RouteFilterUseCase {
    @Override
    public List<InterconnectionResponse> execute(String departure, String arrival, DateTime departureDateTime,
                                                 DateTime arrivalDateTime) {

        return Collections.emptyList();
    }
}
