package com.jingen.booking.controller;

import com.jingen.booking.config.WebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.StreamSupport;

/**
 * describe:
 *
 * @author heart-dawn
 * @date 2019/02/24
 */
// 返回Json对象
@Controller
public class EmployeeController extends WebConfig {

      @RequestMapping("/index")
      public ModelAndView index(){
            ModelAndView modelAndView = createNewModelAndView();
            modelAndView.setViewName("page/index");
            return modelAndView;
      }

}
