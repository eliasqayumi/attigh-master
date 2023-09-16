package com.example.attigh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtudeListResponseDTO {
    private String projectName;
    private List<EtudeNeighbourhoodDTO> neighbourhoods;
}
