package com.erjean.greenojjudgeservice;


import com.erjean.greenojjudgeservice.strategy.DefaultJudgeStrategy;
import com.erjean.greenojjudgeservice.strategy.JavaLanguageJudgeStrategy;
import com.erjean.greenojjudgeservice.strategy.JudgeContext;
import com.erjean.greenojmodel.dto.questionsubmit.JudgeInfo;
import com.erjean.greenojmodel.entity.QuestionSubmit;
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



