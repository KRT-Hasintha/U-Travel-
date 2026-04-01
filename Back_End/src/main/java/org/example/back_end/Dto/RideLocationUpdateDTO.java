package org.example.back_end.Dto;

import lombok.Data;

@Data
public class RideLocationUpdateDTO {
    private Long rideId;
    private Double latitude;
    private Double longitude;
}