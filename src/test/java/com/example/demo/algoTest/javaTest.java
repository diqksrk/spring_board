package com.example.demo.algoTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class javaTest {
    private static final Logger logger = LoggerFactory.getLogger(javaTest.class);

    private int[] step1 = {94, 60, 60};
    int[] completeTest = {100, 100, 60};
    int[] completeTest2 = {100, 90, 60};
    int[] completeTest3 = {100, 100, 100};

    @Test
    public void main() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        solution(progresses, speeds);
;    }


    public int[] solution(int[] progresses, int[] speeds) {
        int curProgram      = 0;
        int completeProram  = 0;
        int checkedProgram  = 0;
        List<Integer> returnList = new LinkedList<>();
        int[] answer        = {};

        while (curProgram < progresses.length) {
            completeProram = 0;
            checkedProgram = 0;

            progresses = progressing(progresses, speeds, curProgram);
            checkedProgram = checkingProgram(progresses, checkedProgram, curProgram);

            if (checkedProgram > 0) {
                completeProram += checkedProgram;
                curProgram     += checkedProgram;
                returnList.add(completeProram);
            }
        }

        answer = new int[returnList.size()];

        for (int i =0; i<answer.length; i++) {
            answer[i] = returnList.get(i);
        }

        return answer;
    }

    public int[] progressing(int[] progress, int[] speeds, int start) {
        for (int i=start; i<progress.length; i++) {
            progress[i] += speeds[i];
        }
        return progress;
    }

    public int checkingProgram(int[] progresses, int checkedProgram, int curProgram) {
        for (int i = curProgram; i<progresses.length; i++) {
            if (progresses[i] >= 100) {
                checkedProgram++;
            } else {
                break;
            }
        }

        return checkedProgram;
    }

    // 아님
    public void progressTest(int[] test) {
        logger.error(Arrays.toString(test));
    }

    // 아님
    public void sstart() {
        logger.error("start");
    }

    @Test
    public void baeyolTest() {
        int[] gogo = new int[10];
        String[] stringGo = new String[10];

        stringGo[2] = "dsada";




        logger.error(Integer.toString(stringGo.length));
        logger.error(Arrays.toString(stringGo));


    }
;}
