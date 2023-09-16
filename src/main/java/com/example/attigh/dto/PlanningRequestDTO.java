package com.example.attigh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanningRequestDTO {
    private Long projectId;
    private Long districtId;
    private Double area;
}
