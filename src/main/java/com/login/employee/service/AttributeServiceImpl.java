package com.login.employee.service;

import com.login.employee.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository attrRepo;

    @Override
    public Optional<AttributeRepository> findById(String id) {
        return attrRepo.findById(id);
    }
}
