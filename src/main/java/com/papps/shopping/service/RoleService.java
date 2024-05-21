package com.papps.shopping.service;

import com.papps.shopping.entity.Role;

import java.util.Collection;
import java.util.Collections;

public interface RoleService {

    Collection<Role>saveRoller(Collection<Role>roles);
    boolean existByName(String roleName);

    Role saveRole(Role role);
}
