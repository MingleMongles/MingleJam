package com.minglemongles.minglejam.sample.query.controller;

import com.minglemongles.minglejam.common.ResponseDTO;
import com.minglemongles.minglejam.common.exception.CommonException;
import com.minglemongles.minglejam.sample.query.serivce.SampleQueryService;
import com.minglemongles.minglejam.sample.query.vo.response.SampleAllResponseVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController("queryRQAnswerController")
@RequestMapping("/api/sample")
@RequiredArgsConstructor
public class SampleQueryController {

    private final SampleQueryService sampleQueryService;

    @GetMapping("/")
    public ResponseDTO<?> getSamples() {
        try {
            List<SampleAllResponseVO> responseVO = sampleQueryService.getSamples();
            return ResponseDTO.ok(responseVO);
        } catch (Exception e) {
            return ResponseDTO.fail(HttpStatus.valueOf(500), "서버 오류 발생");
        }

    }

}
