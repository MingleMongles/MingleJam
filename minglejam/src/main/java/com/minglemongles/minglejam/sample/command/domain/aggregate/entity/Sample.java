package com.minglemongles.minglejam.sample.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_sample")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Sample {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
