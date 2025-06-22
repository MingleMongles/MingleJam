package com.minglemongles.minglejam.sample.command.application.service;

import com.minglemongles.minglejam.common.exception.CommonException;
import com.minglemongles.minglejam.common.exception.ErrorCode;
import com.minglemongles.minglejam.sample.command.application.dto.SampleDTO;
import com.minglemongles.minglejam.sample.command.domain.aggregate.entity.Sample;
import com.minglemongles.minglejam.sample.command.domain.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commandSampleService")
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    @Override
    @Transactional
    public void createSample(SampleDTO sampleDTO) {
        try {
            Sample sample = Sample.builder()
                    .id(sampleDTO.getId())
                    .name(sampleDTO.getName())
                    .build();
            sampleRepository.save(sample);
        } catch (Exception e) {
            throw new CommonException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
