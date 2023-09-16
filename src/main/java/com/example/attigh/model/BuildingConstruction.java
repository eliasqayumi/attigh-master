package com.example.attigh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BuildingConstruction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Neighbourhood neighbourhoodId;

    private Double registeredArea;
    private Double way;
    private Double stabilized;
    private Double drainage;
    private Double draft;
    private Double leveling;
    private Double newParcelNumber;
    private Double consolidationRate;
    private Double businessParcelNumberNew;
    private Double businessParcelNumberOld;
    private Double parcelAverageAreaOld;
    private Double otkpRatio;
    private Double cost;
    private LocalDate registrationDate;
}
