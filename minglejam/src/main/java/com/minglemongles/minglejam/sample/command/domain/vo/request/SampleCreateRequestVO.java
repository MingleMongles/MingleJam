package com.minglemongles.minglejam.sample.command.domain.vo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleCreateRequestVO {
    private Long id;
    private String name;

}
