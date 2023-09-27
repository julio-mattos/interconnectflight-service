package com.ryanair.interconnectflight.clients;

import com.ryanair.interconnectflight.clients.response.RoutesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "routes", url = "${clients.apiRoutes}")
public interface ApiRoutes {

    @GetMapping
    List<RoutesResponse> getRoutes();
}
