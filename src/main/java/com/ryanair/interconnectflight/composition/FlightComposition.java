package com.ryanair.interconnectflight.composition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightComposition {

    private String carrierCode;
    private String number;
    private String departureTime;
    private String arrivalTime;

}
