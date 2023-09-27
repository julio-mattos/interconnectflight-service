package com.ryanair.interconnectflight.controller;
import com.ryanair.interconnectflight.interactors.impl.InterconnectionUseCaseImpl;
import com.ryanair.interconnectflight.openapi.api.InterconnectionsApi;
import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class InterconnectionController implements InterconnectionsApi {

    private final InterconnectionUseCaseImpl interconnectionUseCase;


    @Override
    public ResponseEntity<List<InterconnectionResponse>> getInterconnection(String departure, String arrival, String departureDateTime, String arrivalDateTime) {
        return ResponseEntity.ok(interconnectionUseCase
                .getInterconnectionFlight(departure, arrival, departureDateTime, arrivalDateTime));
    }

}
