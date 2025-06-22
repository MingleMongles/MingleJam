package com.minglemongles.minglejam.sample.query.serivce;

import com.minglemongles.minglejam.sample.query.vo.response.SampleAllResponseVO;

import java.util.List;

public interface SampleQueryService {
    List<SampleAllResponseVO> getSamples();
}
