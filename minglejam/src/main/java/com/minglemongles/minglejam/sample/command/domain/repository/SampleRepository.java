package com.minglemongles.minglejam.sample.command.domain.repository;

import com.minglemongles.minglejam.sample.command.domain.aggregate.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
