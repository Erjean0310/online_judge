package com.erjean.greenojjudgeservice.codesandbox.impl;


import com.erjean.greenojjudgeservice.codesandbox.CodeSandbox;
import com.erjean.greenojmodel.codesandbox.ExecuteCodeRequest;
import com.erjean.greenojmodel.codesandbox.ExecuteCodeResponse;
import com.erjean.greenojmodel.dto.questionsubmit.JudgeInfo;
import com.erjean.greenojmodel.enums.JudgeInfoMessageEnum;
import com.erjean.greenojmodel.enums.QuestionSubmitStatusEnum;

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
