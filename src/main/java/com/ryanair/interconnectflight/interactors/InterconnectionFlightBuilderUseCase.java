package com.ryanair.interconnectflight.interactors;

import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import org.joda.time.DateTime;

import java.util.List;

public interface InterconnectionFlightBuilderUseCase {

    InterconnectionFlightBuilderUseCase filterRoute(RouteFilterUseCase filterUseCase,
                                                    String departure, String arrival,
                                                    DateTime departureDateTime, DateTime arrivalDateTime);

    public List<InterconnectionResponse> build();

}
