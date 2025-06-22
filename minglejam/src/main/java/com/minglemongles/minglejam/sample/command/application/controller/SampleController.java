package com.minglemongles.minglejam.sample.command.application.controller;

import com.minglemongles.minglejam.common.ResponseDTO;
import com.minglemongles.minglejam.sample.command.application.dto.SampleDTO;
import com.minglemongles.minglejam.sample.command.application.service.SampleService;
import com.minglemongles.minglejam.sample.command.domain.vo.request.SampleCreateRequestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("commandSampleController")
@RequestMapping("/api/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @PostMapping
    public ResponseDTO<?> createSample(@RequestBody SampleCreateRequestVO vo) {
        try {
            SampleDTO sampleDTO = SampleDTO.builder()
                    .id((vo.getId()))
                    .name(vo.getName())
                    .build();

            sampleService.createSample(sampleDTO);
            return ResponseDTO.ok("샘플이 등록되었습니다.");
        } catch (Exception e) {
            return ResponseDTO.fail("샘플 등록 중 오류가 발생했습니다." + e.getMessage());
        }
    }
}
