package com.dunkin.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dunkin.app.entity.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
