package com.major.schedule.controller;

import com.major.schedule.entity.City;
import com.major.schedule.entity.CityResp;
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

        Customer customer = new Customer();
        customer.setRemark("github");
        customer.setName("meijieman");
        model.addAttribute("my_github", customer);
        model.addAttribute("page_title", "网页标题");
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
    public void list(@ModelAttribute(value = "customer_resp") CustomerResp resp) {
        log.info("list " + resp);

    }

    @GetMapping("/select")
    public String selectCity(Model model){

        CityResp resp = new CityResp();
        List<City> list = new ArrayList<>();
        City wuhan = new City();
        wuhan.setCode(100);
        wuhan.setName("武汉");
        list.add(wuhan);
        City xinyang = new City();
        xinyang.setCode(101);
        xinyang.setName("信阳");
        list.add(xinyang);
        City shenzhen = new City();
        shenzhen.setCode(102);
        shenzhen.setName("深圳");
        list.add(shenzhen);
        resp.setCityList(list);
        model.addAttribute("cityResp", resp);

        model.addAttribute("selectedCode", -1);
        return "city";
    }


}
