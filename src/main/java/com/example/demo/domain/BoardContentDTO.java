package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardContentDTO {
    private String boardSubject;
    private String boardContent;
    private int boardWriterIdx;
    private int contentBoardIdx;

    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
    private String imageUrl;
}
