package com.erjean.greenojjudgeservice.strategy;


import com.erjean.greenojmodel.dto.question.JudgeCase;
import com.erjean.greenojmodel.dto.questionsubmit.JudgeInfo;
import com.erjean.greenojmodel.entity.Question;
import com.erjean.greenojmodel.entity.QuestionSubmit;
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
