package com.example.attigh.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Neighbourhood neighbourhoodId;

    private Double registrationNumber;
    private Double wagesNumber;
    private Double registeredArea;
    private Double path;
    private Double stabilized;
    private Double drainage;
    private Double stoneTransport;
    private Double leveling;
    private Double newParcelsAmount;
    private Double consolidation;
    private Double newParcelsBusinessNumber;
    private Double oldParcelsBusinessNumber;
    private Double oldParcelAverageArea;
    private Double newParcelAverageArea;
    private Double otkpRatio;
    private Double cost;
    private LocalDate registrationDate;
    private Double landRegistry;
    private Double AnnualPricesWithCost;
}
