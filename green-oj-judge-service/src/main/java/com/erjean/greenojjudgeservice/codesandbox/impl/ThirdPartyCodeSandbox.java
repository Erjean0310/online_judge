package com.erjean.greenojjudgeservice.codesandbox.impl;


import com.erjean.greenojjudgeservice.codesandbox.CodeSandbox;
import com.erjean.greenojmodel.codesandbox.ExecuteCodeRequest;
import com.erjean.greenojmodel.codesandbox.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
