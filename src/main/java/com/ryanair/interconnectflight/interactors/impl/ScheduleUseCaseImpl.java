package com.ryanair.interconnectflight.interactors.impl;

import com.ryanair.interconnectflight.clients.ApiSchedule;
import com.ryanair.interconnectflight.clients.response.ScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleUseCaseImpl {

    private final ApiSchedule apiSchedule;

    public ScheduleResponse getSchedule(String departure, String arrival,
                                        DateTime departureDateTime, DateTime arrivalDateTime) {

        return apiSchedule.getSchedule(departure,
                arrival, departureDateTime.getYear(), arrivalDateTime.getMonthOfYear());
    }


}
