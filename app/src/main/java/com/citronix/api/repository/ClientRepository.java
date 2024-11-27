package com.citronix.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citronix.api.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNameAndPhoneAndEmail(String name, String phone, String email);
}
