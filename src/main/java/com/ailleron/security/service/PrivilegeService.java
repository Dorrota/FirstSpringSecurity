package com.ailleron.security.service;

import com.ailleron.security.domain.Privilege;

public interface PrivilegeService {

    Privilege findPrivilegeByName(String name);
}
