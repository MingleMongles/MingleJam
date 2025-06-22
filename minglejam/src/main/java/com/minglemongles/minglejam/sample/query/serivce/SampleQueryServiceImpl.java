package com.minglemongles.minglejam.sample.query.serivce;

import com.minglemongles.minglejam.common.exception.CommonException;
import com.minglemongles.minglejam.common.exception.ErrorCode;
import com.minglemongles.minglejam.sample.command.domain.aggregate.entity.Sample;
import com.minglemongles.minglejam.sample.query.repository.SampleMapper;
import com.minglemongles.minglejam.sample.query.vo.response.SampleAllResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SampleQueryServiceImpl implements SampleQueryService {

    private final SampleMapper sampleMapper;

    @Override
    public List<SampleAllResponseVO> getSamples() {
        List<Sample> samples = sampleMapper.findAllSamples();

        if (samples == null)
            throw new CommonException(ErrorCode.NOT_FOUND_SAMPLE);

        return samples.stream()
                .map(sample -> SampleAllResponseVO.builder()
                        .id(sample.getId())
                        .name(sample.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
