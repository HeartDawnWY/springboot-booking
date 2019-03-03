package com.jingen.booking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;

public class WebConfig {

    @Value("${com.jingen.booking.domain}")
    private String domain;

    protected ModelAndView createNewModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        registerComConfig(modelAndView);
        return modelAndView;
    }

    protected void registerComConfig(ModelAndView modelAndView){
        modelAndView.addObject("domain", domain);
    }
}
