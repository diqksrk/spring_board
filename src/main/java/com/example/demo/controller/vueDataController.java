package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.BoardInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@AllArgsConstructor
@Controller
public class vueDataController {

    private BoardInfoService boardInfoService;

    @GetMapping(value = "/server/get_board_info",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<BoardInfoDTO>> getBoardInfo() {

        return new ResponseEntity<>(boardInfoService.getBoardList(), HttpStatus.OK);
    }

    @PostMapping(value = "/server/check_user")
    public ResponseEntity<Map> getUserCount(@RequestBody UserInfoDTO vo) {
        Map<String, Integer> map = new HashMap<>();
        map.put("total", boardInfoService.getUserCount(vo));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "/server/new_user", produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> create(@RequestBody UserInfoDTO vo) {

        log.info("ReplyVO: " + vo);

        int insertCount = boardInfoService.register(vo);

        log.info("Reply insert COUNT : " + insertCount);

        return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping(value = "/server/validation_check_user")
    public ResponseEntity<Map> getUserId(@RequestBody UserInfoDTO vo) {

        log.info("ReplyVO: " + vo);

        Map<String, UserInfoDTO> map = new HashMap<>();
        map.put("result", boardInfoService.getUserId(vo));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping(value = "/server/setUserInfo")
    public ResponseEntity<String> setUserInfo(@RequestBody UserInfoDTO vo) {

        log.info("ReplyVO: " + vo);

        int updateCount = boardInfoService.setUserInfo(vo);

        log.info("Reply insert COUNT : " + updateCount);

        return updateCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/server/get_board_list")
    public ResponseEntity<BoardInfoDTO> getBoardNameLIst(@RequestBody BoardInfoDTO vo) {

        log.info("ReplyVO: " + vo);
        vo.setPageAmount(10);
        BoardInfoDTO boardInfoDTO = boardInfoService.getBoardNameList(vo);
        boardInfoDTO.setBoardContentForLists(boardInfoService.getBoardContentList(vo));
        boardInfoDTO.setPageDetail(new PageDTO(new Criteria(vo.getPage(), vo.getPageAmount()), boardInfoService.getTotalBoardContentCount(vo)));

        return new ResponseEntity<>(boardInfoDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/server/register_board_content")
    public ResponseEntity<String> getBoardLIst(@RequestBody BoardContentDTO vo) {
        log.info("ReplyVO: " + vo);
        int insertCount = 0;
        insertCount = boardInfoService.BoardContentRegister(vo);
        String val = boardInfoService.getCurrentVal();
        log.info("Reply insert COUNT : " + insertCount);

        return insertCount == 1 ? new ResponseEntity<String>(val, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/server/modify_board_content")
    public ResponseEntity<String> modifyBoardContent(@RequestBody BoardContentDetail vo) {
        log.info("ReplyVO: " + vo);
        int modifyCount = 0;
        modifyCount  = boardInfoService.modifyBoardContent(vo);

        return modifyCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/server/delete_content")
    public ResponseEntity<String> deleteBoardContent(@RequestBody BoardContentDetail vo) {
        log.info("ReplyVO: " + vo);
        int deleteCount = 0;
        deleteCount  = boardInfoService.deleteBoardContent(vo);

        return deleteCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/server/board/get_content")
    public ResponseEntity<BoardContentDetail> get(@RequestBody VueCriteria vo){
        log.info("/get or modify");
        return new ResponseEntity<>(boardInfoService.getBoardContent(vo), HttpStatus.OK);
    }

    @PostMapping(value = "/server/get_top_board_list")
    public ResponseEntity<BoardInfoDTO> getTopBoardLIst(@RequestBody BoardInfoDTO vo) {

        log.info("ReplyVO: " + vo);
        BoardInfoDTO boardInfoDTO = boardInfoService.getBoardNameList(vo);
        boardInfoDTO.setBoardContentForLists(boardInfoService.get_top_board_list(vo));

        return new ResponseEntity<>(boardInfoDTO, HttpStatus.OK);
    }

}
