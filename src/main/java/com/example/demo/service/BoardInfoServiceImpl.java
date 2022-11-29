package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.mapper.BoardInfoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j2
@Service
@AllArgsConstructor
public class BoardInfoServiceImpl implements BoardInfoService{
    private static String cdnPlusUrl = "https://gafuppqfeiae14956844.cdn.ntruss.com";
    BoardInfoMapper mapper;
    private FileUploadService fileUploadService;

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
        List<BoardContentForList> boardContentList = mapper.getBoardContentList(vo);

        return boardContentList;
    }

    @Override
    public int getTotalBoardContentCount(BoardInfoDTO vo) {
        return mapper.getTotalBoardContentCount(vo);
    }

    @Override
    public BoardContentDetail getBoardContent(VueCriteria vo) {
        BoardContentDetail boardContent = mapper.getBoardContent(vo);

        return boardContent;
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


    @Override
    public int addBoard(BoardContentDTO boardContentDTO, List<MultipartFile> files) throws Exception {

        BoardContentDTO list = parseFileInfo(boardContentDTO, files);
        fileUploadService.uploadFile(list);

        return mapper.BoardContentRegister(boardContentDTO);
    }

    public BoardContentDTO parseFileInfo(
            BoardContentDTO boardContentDTO,
            List<MultipartFile> multipartFiles
    ) throws Exception{
        // 파일이 빈 것이 들어오면 빈 것을 반환
        if(multipartFiles.isEmpty()){
            return boardContentDTO;
        }

        // 파일 이름을 업로드 한 날짜로 바꾸어서 저장할 것이다
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        // 파일이 빈 것이 들어오면 빈 것을 반환
        if(multipartFiles.isEmpty()){
            return boardContentDTO;
        }

        // 프로젝트 폴더에 저장하기 위해 절대경로를 설정 (Window 의 Tomcat 은 Temp 파일을 이용한다)
        String absolutePath = new File("").getAbsolutePath() + "\\";

        // 경로를 지정하고 그곳에다가 저장할 심산이다
        String path = "images/" + current_date;
        File file = new File(path);
        // 저장할 위치의 디렉토리가 존지하지 않을 경우
        if(!file.exists()){
            // mkdir() 함수와 다른 점은 상위 디렉토리가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }

        // 파일들을 이제 만져볼 것이다
        for (MultipartFile multipartFile : multipartFiles){
            // 파일이 비어 있지 않을 때 작업을 시작해야 오류가 나지 않는다
            if(!multipartFile.isEmpty()){
                // jpeg, png, gif 파일들만 받아서 처리할 예정
                String contentType = multipartFile.getContentType();
                String originalFileExtension;
                // 확장자 명이 없으면 이 파일은 잘 못 된 것이다
                if (ObjectUtils.isEmpty(contentType)){
                    break;
                }
                else{
                    if(contentType.contains("image/jpeg")){
                        originalFileExtension = ".jpg";
                    }
                    else if(contentType.contains("image/png")){
                        originalFileExtension = ".png";
                    }
                    else if(contentType.contains("image/gif")){
                        originalFileExtension = ".gif";
                    }
                    // 다른 파일 명이면 아무 일 하지 않는다
                    else{
                        break;
                    }
                }
                // 각 이름은 겹치면 안되므로 나노 초까지 동원하여 지정
                String new_file_name = Long.toString(System.nanoTime()) + originalFileExtension;

                boardContentDTO.setOriginalFileName(multipartFile.getOriginalFilename());
                boardContentDTO.setStoredFilePath(path + "/" + new_file_name);
                boardContentDTO.setFileSize(multipartFile.getSize());
                boardContentDTO.setImageUrl(cdnPlusUrl + "/" + multipartFile.getOriginalFilename());

                // 저장된 파일로 변경하여 이를 보여주기 위함
                file = new File(absolutePath + path + "/" + new_file_name);
                multipartFile.transferTo(file);
            }
        }

        return boardContentDTO;
    }
}
