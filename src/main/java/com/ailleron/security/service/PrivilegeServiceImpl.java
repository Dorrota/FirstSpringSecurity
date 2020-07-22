package com.ailleron.security.service;

import com.ailleron.security.domain.Privilege;
import com.ailleron.security.repository.PrivilegeRepository;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

    private final PrivilegeRepository privilegeRepository;

    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Privilege findPrivilegeByName(String name) {
        return privilegeRepository.findPrivilegeByName(name);
    }
}
