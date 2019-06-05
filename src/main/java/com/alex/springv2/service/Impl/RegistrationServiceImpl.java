package com.alex.springv2.service.Impl;

import com.alex.springv2.domain.Entity.User;
import com.alex.springv2.domain.Role;
import com.alex.springv2.service.RegistrationService;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
public class RegistrationServiceImpl implements RegistrationService {



    @Override
    public void addNewUser(User user) {
        user.setAccountStatus(true);
        user.setRole(Role.USER);
    }
}
