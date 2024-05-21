package com.papps.shopping.service;

import com.papps.shopping.entity.Role;
import com.papps.shopping.repostory.RoleRepository;

import java.util.Collection;

public class RoleServiceImpl implements RoleService {
    private RoleRepository repository;

    @Override
    public Collection<Role> saveRoller(Collection<Role> roles) {

        if (roles == null || roles.isEmpty()) {
            throw new RuntimeException("Roles cannot be null or empty ");//todo burasi projeye exception ekledikten sonra degisecek

        }
        return repository.saveAll(roles);
    }

    @Override
    public boolean existByName(String roleName) {
        return repository.existsByName(roleName);
    }

    @Override
    public Role saveRole(Role role) {
        if(role==null || role.getName().isEmpty()){
            throw new RuntimeException("Roles cannot be null or name cannot be empty ");//todo burasi projeye exception ekledikten sonra degisecek
        }
        if (existByName(role.getName())){
            throw new RuntimeException("Role already exist!");
        }
        var result=repository.save(role);
        repository.flush();

        return result;
    }
}
