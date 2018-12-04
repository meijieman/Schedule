package com.major.schedule.controller;

import com.major.schedule.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ScheduleController {

    public static final Logger log = LoggerFactory.getLogger(ScheduleController.class);

    @GetMapping("/index")
    public String login(Model model){
        log.info("调用 login");
        model.addAttribute("title", "welcome to Schedule.");
        User user = new User();
        user.setUsername("major");
        user.setPassword("pw1234");
        model.addAttribute("s_user", user);
        return "login";
    }

    @PostMapping("/login")
    public String check(@ModelAttribute(value = "s_user") User user) {
        log.info("调用 check " + user);


        return "home";
    }

}
