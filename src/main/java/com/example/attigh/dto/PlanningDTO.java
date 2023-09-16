package com.example.attigh.dto;

import com.example.attigh.model.District;
import com.example.attigh.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanningDTO {
    private Project project;
    private List<DistrictPlanningDTO> districts;

}
