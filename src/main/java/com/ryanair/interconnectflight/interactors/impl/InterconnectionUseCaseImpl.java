package com.ryanair.interconnectflight.interactors.impl;

import com.ryanair.interconnectflight.interactors.InterconnectionFlightBuilderUseCase;
import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterconnectionUseCaseImpl {

    private final InterconnectionFlightBuilderUseCase interconnectionFlightBuilderUseCase;
    private final DirectFlightFilterUseCaseImpl directFlightFilterUseCase;
    private final OneStopFlightFilterUseCaseImpl oneStopFlightFilterUseCase;


    public List<InterconnectionResponse> getInterconnectionFlight(
            String departure, String arrival, String departureDateTime, String arrivalDateTime){

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTime departureDate = DateTime.parse(departureDateTime, formatter);
        DateTime arrivalDate = DateTime.parse(arrivalDateTime, formatter);

        return interconnectionFlightBuilderUseCase
                .filterRoute(directFlightFilterUseCase, departure, arrival, departureDate, arrivalDate)
                .filterRoute(oneStopFlightFilterUseCase, departure, arrival, departureDate, arrivalDate)
                .build();
    }

}
