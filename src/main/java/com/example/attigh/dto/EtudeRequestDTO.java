package com.example.attigh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudeRequestDTO {
    private Long projectId;
    private Long neighbourhoodId;
    private Double regulationArea;
    private Integer numberOfBlock;
    private Integer numberOfBusiness;
    private Integer cadNumberOfParcels;
    private Double way;
}
