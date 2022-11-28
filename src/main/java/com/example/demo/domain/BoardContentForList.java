package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardContentForList {
    private int contentIdx;
    private String contentSubject;

    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String contentDate;
    private String userName;
}
