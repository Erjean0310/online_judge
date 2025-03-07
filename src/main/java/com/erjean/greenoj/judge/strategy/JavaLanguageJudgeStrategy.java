package com.erjean.greenoj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.erjean.greenoj.judge.JudgeStrategy;
import com.erjean.greenoj.model.dto.question.JudgeCase;
import com.erjean.greenoj.model.dto.question.JudgeConfig;
import com.erjean.greenoj.model.dto.questionsubmit.JudgeInfo;
import com.erjean.greenoj.model.entity.Question;
import com.erjean.greenoj.model.enums.JudgeInfoMessageEnum;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy {
    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        Question question = judgeContext.getQuestion();

        JudgeInfo judgeInfoResponse = new JudgeInfo();

        // 判断输出数与输入数是否相等
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        if (outputList.size() != inputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }

        // 判断每项输出是否符合预期
        for (int i = 0; i < judgeCaseList.size(); i++) {
            JudgeCase judgeCase = judgeCaseList.get(i);
            if (!outputList.get(i).equals(judgeCase.getOutput())) {
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }

        // 判断题目限制
        Long time = judgeInfo.getTime();
        Long memory = Optional.ofNullable(judgeInfo.getMemory()).orElse(0L);

        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);

        // 假设 Java 程序本身需要额外执行 10 秒钟
        long JAVA_PROGRAM_TIME_COST = 10000L;
        Long timeLimit = judgeConfig.getTimeLimit() + JAVA_PROGRAM_TIME_COST;
        Long memoryLimit = judgeConfig.getMemoryLimit();

        if (time > timeLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
        } else if (memory > memoryLimit) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
        }

        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        judgeInfoResponse.setTime(time);
        judgeInfoResponse.setMemory(memory);
        return judgeInfoResponse;
    }
}
