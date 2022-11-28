package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VueCriteria {

    private int boardInfoIdx;
    private int contentIdx;
    private String page;
}
