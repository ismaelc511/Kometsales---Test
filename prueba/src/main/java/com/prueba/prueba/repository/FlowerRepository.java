package com.prueba.prueba.repository;

import com.prueba.prueba.models.Flower;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Integer> {

    @Query(countQuery="SELECT * FROM flowers f WHERE f.id = ?1", nativeQuery = true)
    List<Flower> getFlowerByName(String name);

    Flower save(Flower flower);

    void deleteAll();

    void deleteById(ID id);

    List<Flower> findAllByOrderByNameDesc();



}
