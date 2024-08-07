package com.papps.shopping.service;

import com.papps.shopping.entity.Role;
import com.papps.shopping.exception.ApiRequestException;
import com.papps.shopping.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public Collection<Role> saveRoller(Collection<Role> roles) {

        if (roles == null || roles.isEmpty()) {
            throw new ApiRequestException("Roles cannot be null or empty");

        }
        return repository.saveAll(roles);
    }

    @Override
    public boolean existByName(String roleName) {
        return repository.existsByName(roleName);
    }

    @Override
    public Role saveRole(Role role) {
        if (role == null || role.getName().isEmpty()) {
            throw new ApiRequestException("Roles cannot be null or name cannot be empty ");
        }
        if (existByName(role.getName())) {
            throw new ApiRequestException("Role already exist!");
        }
        var result = repository.save(role);
        repository.flush();

        return result;
    }

    @Override
    public Role findByName(String name) {
        var role = repository.findByName(name);
        return role.orElseThrow(() -> new RuntimeException("role not found"));
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();

    }
}
