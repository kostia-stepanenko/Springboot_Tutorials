package com.oreilly.demo.dao;


import com.oreilly.demo.entities.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer,Integer > {

}
