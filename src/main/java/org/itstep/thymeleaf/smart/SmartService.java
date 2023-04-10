package org.itstep.thymeleaf.smart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartService {

    @Autowired
    private SmartRepository smartRepository;

    public List<Smart> findAll() {
        return smartRepository.findAll();
    }

    public Smart save(Smart smart) {
        return smartRepository.save(smart);
    }

    public Smart findById(Long id) {
        return smartRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        smartRepository.deleteById(id);
    }
}
