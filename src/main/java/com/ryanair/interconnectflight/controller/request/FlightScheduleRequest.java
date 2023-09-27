package com.ryanair.interconnectflight.controller.request;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightScheduleRequest {

    private String departure;
    private String arrival;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private DateTime departureDateTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private DateTime arrivalDateTime;

}
