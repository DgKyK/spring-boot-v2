package com.alex.springv2.service.impl;

import com.alex.springv2.domain.entity.User;
import com.alex.springv2.domain.Role;
import com.alex.springv2.service.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {



    @Override
    public void addNewUser(User user) {
        user.setAccountStatus(true);
        user.setRole(Role.USER);
    }
}
