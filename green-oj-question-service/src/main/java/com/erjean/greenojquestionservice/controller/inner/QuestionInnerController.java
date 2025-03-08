package com.erjean.greenojquestionservice.controller.inner;

import com.erjean.greenojmodel.entity.Question;
import com.erjean.greenojmodel.entity.QuestionSubmit;
import com.erjean.greenojquestionservice.service.QuestionService;
import com.erjean.greenojquestionservice.service.QuestionSubmitService;
import com.erjean.greenojserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 内部调用接口
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {
    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;
    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("id") Long id) {
        return questionService.getById(id);
    }


    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionSubmitId") Long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }


    @Override
    @PostMapping("/question_submit/update")
    public Boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit) {
        return questionSubmitService.updateById(questionSubmit);
    }
}
