package com.papps.shopping;

import com.papps.shopping.entity.Role;
import com.papps.shopping.entity.User;
import com.papps.shopping.service.RoleService;
import com.papps.shopping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ShoppingApplication implements CommandLineRunner {
    private final UserService userService;
    private final RoleService roleService;


    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var roles = List.of(new Role("SUPER_ADMIN"), new Role("ADMIN"), new Role("USER"));

        for (Role role : roles) {
            if (!roleService.existByName(role.getName())) {
                roleService.saveRole(role);
            }
        }
        var savedRoles = roleService.findAll();
        if (!savedRoles.isEmpty()) {
            var users = List.of(new User("Super Admin", "superadmin@demo.com.local", "1234"),
                    new User("Admin", "admin@demo.com.local", "1234"),
                    new User("User", "user@demo.com.local", "1234"));

            users.get(0).getRoles().add(savedRoles.get(0));
            users.get(0).getRoles().add(savedRoles.get(1));
            users.get(0).getRoles().add(savedRoles.get(2));

            users.get(1).getRoles().add(savedRoles.get(1));
            users.get(1).getRoles().add(savedRoles.get(2));

            users.get(2).getRoles().add(roles.get(2));

            users.forEach(user -> {
                if (!userService.existByMail(user.getMail())) {
                    userService.save(user);
                }
            });
        }


    }
}
