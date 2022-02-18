package com.offreapi.offreapi.auth.repository;

import com.offreapi.offreapi.auth.models.ERole;
import com.offreapi.offreapi.auth.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
