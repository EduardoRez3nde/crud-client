package com.rezende.CRUDClient.repository;

import com.rezende.CRUDClient.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
