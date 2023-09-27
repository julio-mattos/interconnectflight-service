package com.ryanair.interconnectflight.interactors.impl;

import com.ryanair.interconnectflight.clients.response.ScheduleResponse;
import com.ryanair.interconnectflight.composition.DayComposition;
import com.ryanair.interconnectflight.interactors.RouteFilterUseCase;
import com.ryanair.interconnectflight.openapi.model.InterconnectionResponse;
import com.ryanair.interconnectflight.openapi.model.LegResponse;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DirectFlightFilterUseCaseImpl implements RouteFilterUseCase {

    private final ScheduleUseCaseImpl apiSchedule;

    @Override
    public List<InterconnectionResponse> execute(String departure, String arrival, DateTime departureDateTime,
                                                 DateTime arrivalDateTime) {

        ScheduleResponse response = apiSchedule.getSchedule(departure, arrival, departureDateTime, arrivalDateTime);
        System.out.println(departureDateTime.dayOfMonth().get());


        List<DayComposition> dayCompositions = response.getDays()
                .stream()
                .filter(d -> d.getDay() >= departureDateTime.dayOfMonth().get())
                .filter(d-> d.getDay() <= arrivalDateTime.dayOfMonth().get())
                .collect(Collectors.toList());

        List<InterconnectionResponse> interconnectionResponseList = new ArrayList<>();

        for (DayComposition day : dayCompositions){
            interconnectionResponseList = day.getFlights().stream()
                    .map(i -> {
                        LegResponse legResponse = new LegResponse();
                        legResponse.departureAirport(departure);
                        legResponse.arrivalAirport(arrival);
                        legResponse.departureDateTime(departureDateTime.withHourOfDay(
                                getHour(i.getDepartureTime())).withMinuteOfHour(getMinute(i.getDepartureTime())).toString());
                        legResponse.arrivalDateTime(arrivalDateTime.withHourOfDay(
                                getHour(i.getArrivalTime())).withMinuteOfHour(getMinute(i.getArrivalTime())).toString());
                        InterconnectionResponse interconnectionResponse = new InterconnectionResponse();
                        interconnectionResponse.legs(List.of(legResponse));
                        interconnectionResponse.stop(0);
                        return interconnectionResponse;
                    }).collect(Collectors.toList());
        }

        return interconnectionResponseList;
    }

    private static int getHour(String date){
        return Integer.parseInt(date.substring(0,2));
    }
    private static int getMinute(String date){
        return Integer.parseInt(date.substring(3));
    }


}
