package com.example.attigh.service.impl;

import com.example.attigh.model.Registration;
import com.example.attigh.repo.RegistrationRepository;
import com.example.attigh.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;


    @Override
    public List<Registration> getAll() {
        return this.registrationRepository.findAll();
    }

    @Override
    public Registration insert(Registration registration) {
        return this.registrationRepository.save(registration);
    }

    @Override
    public Registration update(Long registrationId, Registration registration) {
        Registration modifyRegistration = this.findById(registrationId);

        modifyRegistration.setRegistrationNumber(registration.getRegistrationNumber());
        modifyRegistration.setWagesNumber(registration.getWagesNumber());
        modifyRegistration.setRegisteredArea(registration.getRegisteredArea());
        modifyRegistration.setPath(registration.getPath());
        modifyRegistration.setStabilized(registration.getStabilized());
        modifyRegistration.setDrainage(registration.getDrainage());
        modifyRegistration.setStoneTransport(registration.getStoneTransport());
        modifyRegistration.setLeveling(registration.getLeveling());
        modifyRegistration.setNewParcelsAmount(registration.getNewParcelsAmount());
        modifyRegistration.setConsolidation(registration.getConsolidation());
        modifyRegistration.setNewParcelsBusinessNumber(registration.getNewParcelsBusinessNumber());
        modifyRegistration.setOldParcelsBusinessNumber(registration.getOldParcelsBusinessNumber());
        modifyRegistration.setOldParcelAverageArea(registration.getOldParcelAverageArea());
        modifyRegistration.setNewParcelAverageArea(registration.getNewParcelAverageArea());
        modifyRegistration.setOtkpRatio(registration.getOtkpRatio());
        modifyRegistration.setCost(registration.getCost());
        modifyRegistration.setRegistrationDate(registration.getRegistrationDate());
        modifyRegistration.setLandRegistry(registration.getLandRegistry());
        modifyRegistration.setAnnualPricesWithCost(registration.getAnnualPricesWithCost());


        return this.registrationRepository.save(modifyRegistration);
    }

    @Override
    public Registration findById(Long registrationId) {
        return this.registrationRepository.findById(registrationId).orElseThrow();
    }

    @Override
    public Registration deleteRegistrationById(Long registrationId) {
        Registration deleteEtude = this.findById(registrationId);
        this.registrationRepository.deleteById(registrationId);
        return deleteEtude;
    }

}
