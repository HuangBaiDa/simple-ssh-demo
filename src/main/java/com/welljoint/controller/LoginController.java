package com.welljoint.controller;

import com.welljoint.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.welljoint.entity.User;

/**
 * @author hbd(modify)
 * 控制器  @Controller -->>注解为控制器 @RequestMapping(value = "/login") -->>截获带有/login的请求
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    /**
     * 注入service层
     */
    @Autowired
    LoginService loginService;

    /**
     * 处理GET请求
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String get() {
        //返回指向login.jsp页面
        return "login";
    }

    /**
     * 处理POST请求
     * 处理用户登录提交的表单信息
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String post(User user) {
        if (loginService.login(user.getUserName(), user.getPassword()) == 1) {
            //登陆成功，跳转到login_success.jsp页面
            return "login_success";
        }
        return "login";
    }
}
