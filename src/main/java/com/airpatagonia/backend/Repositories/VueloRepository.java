package com.airpatagonia.backend.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airpatagonia.backend.models.Vuelo;

import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    List<Vuelo> findAll();
}
