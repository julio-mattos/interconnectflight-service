package com.ryanair.interconnectflight.clients.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoutesResponse {

    private String airportFrom;
    private String airportTo;
    private String connectingAirport;
    private boolean newRoute;
    private boolean seasonalRoute;
    private String operator;
    private String carrierCode;
    private String group;
    private List<String> similarArrivalAirportCodes;
    private List<String> tags;
}
