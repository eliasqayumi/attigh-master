package com.example.attigh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudeNeighbourhoodDTO {
    private String neighbourhoodName;
    private Double regulationArea;
    private Integer numberOfBlock;
    private Integer numberOfBusiness;
    private Integer cadNumberOfParcels;
    private Double way;
}
