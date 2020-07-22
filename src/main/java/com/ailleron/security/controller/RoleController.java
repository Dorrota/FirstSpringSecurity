package com.ailleron.security.controller;

import com.ailleron.security.domain.Privilege;
import com.ailleron.security.domain.Role;
import com.ailleron.security.service.PrivilegeService;
import com.ailleron.security.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RoleController {

    private final PrivilegeService privilegeService;
    private final RoleService roleService;

    public RoleController(PrivilegeService privilegeService, RoleService roleService) {
        this.privilegeService = privilegeService;
        this.roleService = roleService;
    }

    @GetMapping("/create-role")
    @ResponseBody
    public String addPrivilegeToRole(){
        Set<Privilege> privileges = new HashSet<>();
        privileges.add(privilegeService.findPrivilegeByName("ANK_PUBLISH_SPACE_PRIVILEGE"));
        privileges.add(privilegeService.findPrivilegeByName("ANK_MNG_PRIVILEGE"));
        Role role = roleService.findRoleByName("ROLE_USER");
        role.setPrivileges(privileges);
        roleService.saveRole(role);
        return "Done";
    }
}
