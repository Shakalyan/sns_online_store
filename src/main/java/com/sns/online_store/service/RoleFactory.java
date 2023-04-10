package com.sns.online_store.service;

import com.sns.online_store.exception.BadRoleNameException;
import com.sns.online_store.model.Role;
import com.sns.online_store.model.Roles;
import com.sns.online_store.repo.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RoleFactory {

    private final RoleRepository roleRepository;

    private List<Role> getManagerRoles() {
        return List.of(roleRepository.findByName(Roles.ROLE_MANAGER.toString()));
    }

    private List<Role> getAdminRoles() {
        return Stream.concat(
            getManagerRoles().stream(),
            Stream.of(roleRepository.findByName(Roles.ROLE_ADMIN.toString()))
        )
        .toList();
    }

    private List<Role> getDevRoles() {
        return Stream.concat(
                getAdminRoles().stream(),
                Stream.of(roleRepository.findByName(Roles.ROLE_DEV.toString()))
        )
        .toList();
    }

    public List<Role> getRolesOf(String mainRole) {
        switch (mainRole) {
            case "ROLE_MANAGER" -> {
                return getManagerRoles();
            }
            case "ROLE_ADMIN" -> {
                return getAdminRoles();
            }
            case "ROLE_DEV" -> {
                return getDevRoles();
            }
        }
        throw new BadRoleNameException(mainRole);
    }

}
