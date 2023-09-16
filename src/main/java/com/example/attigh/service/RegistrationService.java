package com.example.attigh.service;

import com.example.attigh.model.Registration;

import java.util.List;

public interface RegistrationService {

    List<Registration> getAll();

    Registration insert(Registration registration);

    Registration update(Long etudeId, Registration registration);

    Registration findById(Long registrationId);
    Registration deleteRegistrationById(Long registrationId);
}
