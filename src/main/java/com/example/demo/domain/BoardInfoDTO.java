package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardInfoDTO {

    private int boardInfoIdx;
    private String boardInfoName;

    private int page;
    private int pageAmount;

    List<BoardContentForList> boardContentForLists;

    PageDTO pageDetail;
}
