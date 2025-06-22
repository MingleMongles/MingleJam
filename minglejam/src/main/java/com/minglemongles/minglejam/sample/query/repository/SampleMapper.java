package com.minglemongles.minglejam.sample.query.repository;

import com.minglemongles.minglejam.sample.command.domain.aggregate.entity.Sample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    List<Sample> findAllSamples();
}
