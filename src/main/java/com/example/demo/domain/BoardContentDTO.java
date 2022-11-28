package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardContentDTO {
    private String boardSubject;
    private String boardContent;
    private int boardWriterIdx;
    private int contentBoardIdx;
}
