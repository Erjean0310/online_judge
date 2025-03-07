package com.erjean.greenoj.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.erjean.greenoj.common.ErrorCode;
import com.erjean.greenoj.exception.BusinessException;
import com.erjean.greenoj.judge.codesandbox.CodeSandbox;
import com.erjean.greenoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.erjean.greenoj.judge.codesandbox.model.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteCodeSandbox implements CodeSandbox {
    private static final String AUTH_REQUEST_HEADER = "auth";
    private static final String AUTH_REQUEST_SECRET = "green-oj";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://localhost:8080/executeCode";
        String jsonStr = JSONUtil.toJsonStr(executeCodeRequest);
        String responseBody = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(jsonStr)
                .execute()
                .body();
        if (StringUtils.isBlank(responseBody)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "远程代码沙箱执行报错");
        }
        return JSONUtil.toBean(responseBody, ExecuteCodeResponse.class);
    }
}
