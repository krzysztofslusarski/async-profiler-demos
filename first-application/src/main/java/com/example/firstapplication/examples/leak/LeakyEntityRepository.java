package com.example.firstapplication.examples.leak;

import org.springframework.data.jpa.repository.JpaRepository;

interface LeakyEntityRepository extends JpaRepository<LeakyEntity, Integer> {
}
