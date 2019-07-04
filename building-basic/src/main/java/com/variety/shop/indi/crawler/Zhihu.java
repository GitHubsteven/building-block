package com.variety.shop.indi.crawler;

import java.util.ArrayList;

/**
 * Created by rongbin.xie on 2017/10/27.
 */
public class Zhihu {
    private String question;// 问题
    private String zhihuUrl;// 网页链接
    private ArrayList<String> answers;// 存储所有回答的数组
    private String questionPageContext;
    private String questionDescription;   //问题描述

    // 构造方法初始化数据
    public Zhihu() {
        question = "";
        zhihuUrl = "";
        answers = new ArrayList<String>();
    }

    @Override
    public String toString() {
        StringBuffer strResult = new StringBuffer("问题：" + question + "\n链接：" + zhihuUrl + "\n问题页面内容：" + questionPageContext + "\n回答：");
        this.answers.forEach(answer -> strResult.append("\n").append(answer));
        return strResult.toString();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getZhihuUrl() {
        return zhihuUrl;
    }

    public void setZhihuUrl(String zhihuUrl) {
        this.zhihuUrl = zhihuUrl;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getQuestionPageContext() {
        return questionPageContext;
    }

    public void setQuestionPageContext(String questionPageContext) {
        this.questionPageContext = questionPageContext;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }
}
