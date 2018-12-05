package com.major.schedule.controller;

import com.major.schedule.entity.Customer;
import com.major.schedule.entity.CustomerResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Major on 2018/12/5
 */
@Controller
@RequestMapping("/")
public class CustomerController {

    public static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/getCustomers")
    public String getCustomers(Model model) {
        log.info("获取");

        List<Customer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            customer.setName("major " + i);
            customer.setRemark("so smart of you ".substring(i));
            list.add(customer);
        }

        model.addAttribute("customers", list);

        return "customers";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute(value = "customers") ArrayList<Customer> list) {
        log.info("modify " + list);
        // FIXME: 2018/12/5 不能提交 list？
        return "customers";
    }



    @RequestMapping("/data")
    public String data(Model model, @ModelAttribute(value = "customer_resp") CustomerResp resp, HttpServletRequest req) {
        log.info("data " + req.getMethod());
        if (resp.getData() == null) {
            resp = new CustomerResp();
            List<Customer> list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Customer customer = new Customer();
                customer.setName("major " + i);
                customer.setRemark("some one like you".substring(i));
                list.add(customer);
            }
            resp.setData(list);
            model.addAttribute("customer_resp", resp);
        } else {
            model.addAttribute("customer_resp", resp.getData());
        }
        return "data";
    }


    @PostMapping("/list")
    public void list(@ModelAttribute(value = "data") CustomerResp resp) {
        log.info("list " + resp);

    }

}
