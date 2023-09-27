package com.ryanair.interconnectflight.clients.response;

import com.ryanair.interconnectflight.composition.DayComposition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleResponse {

    private Integer month;
    List<DayComposition> days;

}
