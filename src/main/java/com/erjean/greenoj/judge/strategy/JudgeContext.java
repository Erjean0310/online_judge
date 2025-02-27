package com.erjean.greenoj.judge.strategy;

import com.erjean.greenoj.model.dto.question.JudgeCase;
import com.erjean.greenoj.model.dto.questionsubmit.JudgeInfo;
import com.erjean.greenoj.model.entity.Question;
import com.erjean.greenoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 判题上下文
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
