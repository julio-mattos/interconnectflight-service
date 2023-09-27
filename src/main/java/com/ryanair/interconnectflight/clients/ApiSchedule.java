package com.ryanair.interconnectflight.clients;

import com.ryanair.interconnectflight.clients.response.ScheduleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "schedule", url = "${clients.apiSchedule}")
public interface ApiSchedule {

    @GetMapping(path = "/{departure}/{arrival}/years/{year}/months/{month}")
    ScheduleResponse getSchedule(@PathVariable String departure, @PathVariable String
            arrival, @PathVariable int year, @PathVariable int month);

}