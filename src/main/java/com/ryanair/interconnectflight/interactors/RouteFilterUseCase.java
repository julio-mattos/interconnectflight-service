package com.ryanair.interconnectflight.interactors;

import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import org.joda.time.DateTime;

import java.util.List;

public interface RouteFilterUseCase {

    List<InterconnectionResponse> execute(String departure, String arrival,
                                          DateTime departureDateTime, DateTime arrivalDateTime);
}
