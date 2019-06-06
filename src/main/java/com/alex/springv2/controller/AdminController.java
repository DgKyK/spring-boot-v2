package com.alex.springv2.controller;

import com.alex.springv2.domain.entity.GeneralStatistic;
import com.alex.springv2.service.impl.GeneralStatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/admin")
@Controller
public class AdminController {

    @Autowired
    GeneralStatisticMapper mapper;

    @RequestMapping(value = "/admin")
    public String adminHome() {
        return "admin";
    }

    @RequestMapping(value = "/statistic")
    public String generalStatistic(Model model) {
        List<GeneralStatistic> statistic = mapper.getGeneralStatistic();
        model.addAttribute("statistic", statistic);
        return "statistic";
    }
}
