package com.example.firstapplication.examples.cpu;

import org.springframework.data.jpa.repository.JpaRepository;

interface SampleConfigurationRepository extends JpaRepository<SampleConfiguration, String> {
}
