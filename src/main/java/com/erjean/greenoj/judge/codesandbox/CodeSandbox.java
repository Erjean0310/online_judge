package com.erjean.greenoj.judge.codesandbox;

import com.erjean.greenoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.erjean.greenoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
