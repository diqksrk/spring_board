//package com.example.demo.TDD;
//
//import lombok.extern.log4j.Log4j2;
//import org.junit.Test;
//
//import java.util.*;
//import java.util.stream.Stream;
//import java.util.Map.Entry;
//
//@Log4j2
//public class testDollar {
//    @Test
//    public void main() {
//        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
//
//        solution(record);
//    }
//
//    private class commandInfo {
//        private String command;
//        private String userId;
//
//        public commandInfo(String command, String userId) {
//            this.command = command;
//            this.userId  = userId;
//        }
//    }
//
//    private class userInfo {
//        private String userId;
//        private String nickName;
//
//        public userInfo(String userId, String nickName) {
//            this.userId = userId;
//            this.nickName = nickName;
//        }
//    }
//
//    public String[] solution(String[] record) {
//
//        ArrayList<commandInfo> commandList = new ArrayList<>();
//        HashMap<String, userInfo> userInfoList   = new HashMap<>();
//
//        for (String str : record) {
//            String[] list = str.split("\\s+");
//            String command = list[0];
//            String userId  = list[1];
//            String nickName = null;
//
//            String commandRowId = list[0] + list[1];
//            String userRowId = list[1];
//
//            if ("Enter".equals(command)) {
//                nickName = list[2];
//                commandList.add(new commandInfo(list[0], list[1]));
//
//                if ( userInfoList.containsKey(userRowId) ) {
//                    userInfoList.get(userRowId).nickName = nickName;
//                } else {
//                    userInfoList.put(userRowId, new userInfo(userId, nickName));
//                }
//
//            } else if ("Leave".equals(command)) {
//                commandList.add(new commandInfo(list[0], list[1]));
//            } // Change
//            else {
//                nickName = list[2];
//                userInfoList.get(userRowId).nickName = nickName;
//            }
//        }
//
//        //log.error(commandList.keySet());
//        for (commandInfo key : commandList) {
//            log.error(key.command + ", " + key.userId);
//        }
//
//        //log.error(commandList.keySet());
//        for (String key : userInfoList.keySet()) {
//            userInfo com = userInfoList.get(key);
//            log.error(com.userId + ", " + com.nickName);
//        }
//
//        String[] answer = new String[commandList.size()-1];
//        for (int i = 0; i<answer.length; i++) {
//            commandInfo curCom = commandList.get(i);
//
//            log.error(userInfoList.get(curCom.userId).nickName);
////            if ("Enter".equals(curCom.command)) {
////                answer[i] = userInfoList.get(curCom.userId) + "님이 들어왔습니다.";
////            } else if ("Leave".equals(curCom.command)) {
////                answer[i] = userInfoList.get(curCom.userId) + "님이 나갔습니다.";
////            }
//        }
//
//        return answer;
//    }
//}
