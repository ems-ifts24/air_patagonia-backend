package com.airpatagonia.backend.repositories;

import org.springframework.stereotype.Repository;

import com.airpatagonia.backend.models.PagoDePasaje;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PagoDePasajeRepository extends JpaRepository<PagoDePasaje, Long> {

    public List<PagoDePasaje> findAll();

}
