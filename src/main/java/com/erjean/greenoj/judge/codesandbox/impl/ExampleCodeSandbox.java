package com.erjean.greenoj.judge.codesandbox.impl;

import com.erjean.greenoj.judge.codesandbox.CodeSandbox;
import com.erjean.greenoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.erjean.greenoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.erjean.greenoj.model.dto.questionsubmit.JudgeInfo;
import com.erjean.greenoj.model.enums.JudgeInfoMessageEnum;
import com.erjean.greenoj.model.enums.QuestionSubmitStatusEnum;


/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("示例代码沙箱");
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(executeCodeRequest.getInputList());
        executeCodeResponse.setMessage("执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getValue());
        judgeInfo.setTime(1000L);
        judgeInfo.setMemory(1000L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        
        return executeCodeResponse  ;
    }
}
