package com.ailleron.security.service;

import com.ailleron.security.domain.Role;

public interface RoleService {

    Role findRoleByName(String name);
    Role saveRole(Role role);
}
