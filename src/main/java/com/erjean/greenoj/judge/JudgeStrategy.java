package com.erjean.greenoj.judge;

import com.erjean.greenoj.judge.strategy.JudgeContext;
import com.erjean.greenoj.model.dto.questionsubmit.JudgeInfo;

/**
 * 判题策略接口
 */
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
