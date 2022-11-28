package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.mapper.BoardInfoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BoardInfoServiceImpl implements BoardInfoService{

    BoardInfoMapper mapper;

    @Override
    public List<BoardInfoDTO> getBoardList() {
        return mapper.getBoardList();
    }

    @Override
    public int register(UserInfoDTO vo) {
        return mapper.register(vo);
    }

    @Override
    public int getUserCount(UserInfoDTO vo) {
        return mapper.getUserCount(vo);
    }

    @Override
    public UserInfoDTO getUserId(UserInfoDTO vo) {
        return mapper.getUserId(vo);
    }

    @Override
    public int setUserInfo(UserInfoDTO vo) {
        return mapper.updateUserInfo(vo);
    }

    @Override
    public BoardInfoDTO getBoardNameList(BoardInfoDTO vo) {
        return mapper.getBoardNameLIst(vo);
    }

    @Override
    public int BoardContentRegister(BoardContentDTO vo) {
        return mapper.BoardContentRegister(vo);
    }

    @Override
    public List<BoardContentForList> getBoardContentList(BoardInfoDTO vo) {
        return mapper.getBoardContentList(vo);
    }

    @Override
    public int getTotalBoardContentCount(BoardInfoDTO vo) {
        return mapper.getTotalBoardContentCount(vo);
    }

    @Override
    public BoardContentDetail getBoardContent(VueCriteria vo) {
        return mapper.getBoardContent(vo);
    }

    @Override
    public String getCurrentVal() {
        return mapper.getCurrentVal();
    }

    @Override
    public int modifyBoardContent(BoardContentDetail vo) {
        return mapper.modifyBoardContent(vo);
    }

    @Override
    public int deleteBoardContent(BoardContentDetail vo) {
        return mapper.deleteBoardContent(vo);
    }

    @Override
    public List<BoardContentForList> get_top_board_list(BoardInfoDTO vo) {
        return mapper.get_top_board_list(vo);
    }
}
