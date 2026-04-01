package org.example.back_end.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RideResponseDTO {
    private Long id;
    private String username;
    private String locationName;
}
