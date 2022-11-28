package com.example.demo.service;

import com.example.demo.domain.*;

import java.util.List;

public interface BoardInfoService {

    public List<BoardInfoDTO> getBoardList();

    int register(UserInfoDTO vo);

    public int getUserCount(UserInfoDTO vo);

    public UserInfoDTO getUserId(UserInfoDTO vo);

    public int setUserInfo(UserInfoDTO vo);

    public BoardInfoDTO getBoardNameList(BoardInfoDTO vo);

    public int BoardContentRegister(BoardContentDTO vo);

    public List<BoardContentForList> getBoardContentList(BoardInfoDTO vo);

    public int getTotalBoardContentCount(BoardInfoDTO vo);

    public BoardContentDetail getBoardContent(VueCriteria vo);

    public String getCurrentVal();

    public int modifyBoardContent(BoardContentDetail vo);

    public int deleteBoardContent(BoardContentDetail vo);

    public List<BoardContentForList> get_top_board_list(BoardInfoDTO vo);
}
