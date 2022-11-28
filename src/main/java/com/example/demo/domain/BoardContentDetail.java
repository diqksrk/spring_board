package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardContentDetail {
    private int contentIdx;
    private String contentSubject;
    private Long contentText;
    private int contentWriterIdx;
    private String userName;
    private String contentDate;
}
