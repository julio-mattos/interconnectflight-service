package com.ryanair.interconnectflight.composition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayComposition {

    private Integer day;
    List<FlightComposition> flights;

}
