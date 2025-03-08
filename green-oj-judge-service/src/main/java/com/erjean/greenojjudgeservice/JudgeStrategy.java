package com.erjean.greenojjudgeservice;


import com.erjean.greenojjudgeservice.strategy.JudgeContext;
import com.erjean.greenojmodel.dto.questionsubmit.JudgeInfo;

/**
 * 判题策略接口
 */
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
