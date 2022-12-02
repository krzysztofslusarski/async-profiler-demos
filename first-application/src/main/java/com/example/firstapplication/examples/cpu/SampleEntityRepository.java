package com.example.firstapplication.examples.cpu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SampleEntityRepository extends JpaRepository<SampleEntity, UUID> {
}
