package com.alex.springv2.service.impl;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutoTestPasserTest {

    @Test
    public void getPassedTest() {
        int questionNumber = 20;
        AutoTestPasser.getPassedTest(questionNumber);
        Assert.assertEquals(questionNumber, AutoTestPasser.getPassedTest(questionNumber).size());
    }
}