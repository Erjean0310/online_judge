package com.erjean.greenojjudgeservice.codesandbox;


import com.erjean.greenojjudgeservice.codesandbox.impl.ExampleCodeSandbox;
import com.erjean.greenojjudgeservice.codesandbox.impl.RemoteCodeSandbox;
import com.erjean.greenojjudgeservice.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱创建工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandboxFactory {
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
