package com.ryanair.interconnectflight.interactors.impl;

import com.ryanair.interconnectflight.interactors.InterconnectionFlightBuilderUseCase;
import com.ryanair.interconnectflight.interactors.RouteFilterUseCase;
import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InterconnectionFlightBuilderUseCaseImpl implements InterconnectionFlightBuilderUseCase{

   private final List<InterconnectionResponse> interconnectionResponseList = new ArrayList<>();

   @Override
   public InterconnectionFlightBuilderUseCase filterRoute(RouteFilterUseCase filterUseCase, String departure,
                                                          String arrival, DateTime departureDateTime, DateTime arrivalDateTime){
       interconnectionResponseList.addAll(filterUseCase.execute(departure, arrival, departureDateTime, arrivalDateTime));
       return this;
   }

   @Override
   public List<InterconnectionResponse> build(){
       return interconnectionResponseList;
   }

}
