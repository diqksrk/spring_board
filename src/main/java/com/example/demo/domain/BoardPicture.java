package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPicture {
    private String boardSubject;
    private String boardContent;
    private int boardWriterIdx;
    private int contentBoardIdx;

    private String original_file_name;
    private String stored_file_path;
    private long file_size;
}
