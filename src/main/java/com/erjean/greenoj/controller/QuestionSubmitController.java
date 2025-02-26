package com.erjean.greenoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erjean.greenoj.annotation.AuthCheck;
import com.erjean.greenoj.common.BaseResponse;
import com.erjean.greenoj.common.ErrorCode;
import com.erjean.greenoj.common.ResultUtils;
import com.erjean.greenoj.constant.UserConstant;
import com.erjean.greenoj.exception.BusinessException;
import com.erjean.greenoj.model.dto.question.QuestionQueryRequest;
import com.erjean.greenoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.erjean.greenoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.erjean.greenoj.model.entity.Question;
import com.erjean.greenoj.model.entity.QuestionSubmit;
import com.erjean.greenoj.model.entity.User;
import com.erjean.greenoj.model.vo.QuestionSubmitVO;
import com.erjean.greenoj.service.QuestionSubmitService;
import com.erjean.greenoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 题目提交接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     * @param questionSubmitAddRequest
     * @param request
     * @return 提交记录 id
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }

    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest, HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        final User loginUser = userService.getLoginUser(request);
        Page<QuestionSubmitVO> questionSubmitVOPage = questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser);
        return ResultUtils.success(questionSubmitVOPage);
    }


}
