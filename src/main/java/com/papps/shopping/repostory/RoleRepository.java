package com.papps.shopping.repostory;

import com.papps.shopping.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByName(String roleName);//burda tekil ama repository de cogul neden
}
