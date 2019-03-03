package com.jingen.booking.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author heart-dawn
 * @date 2019/02/24
 */
@Configuration
public class FilterBeanConfig {

    @Bean
    public FilterRegistrationBean logFiler(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new LogFilter());

        List<String> urList = new ArrayList<String>();
        urList.add("*");
        filterRegistrationBean.setUrlPatterns(urList);
        return filterRegistrationBean;
    }
}
