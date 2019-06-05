package com.alex.springv2.service;

import java.util.Map;

public interface StudentSuccessService {
    void saveCurrentResult(Map<String,Boolean> resultTest, String testInfo, String userName);
}
