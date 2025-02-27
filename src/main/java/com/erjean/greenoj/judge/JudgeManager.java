package com.erjean.greenoj.judge;

import com.erjean.greenoj.judge.strategy.JudgeContext;
import com.erjean.greenoj.judge.strategy.DefaultJudgeStrategy;
import com.erjean.greenoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.erjean.greenoj.model.dto.questionsubmit.JudgeInfo;
import com.erjean.greenoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理
 */
@Service
public class JudgeManager {
    JudgeInfo doJudge(JudgeContext judgeContext) {

        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}



