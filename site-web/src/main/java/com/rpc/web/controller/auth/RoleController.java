package com.rpc.web.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rpc.auth.model.Role;
import com.rpc.auth.service.AuthService;
import com.rpc.framework.base.Page;

@Controller
@RequestMapping("role")
public class RoleController {

    private final static Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "manager", method = RequestMethod.GET)
    public String roleManager(ModelMap model) {
        log.info("#进入角色管理页面");

        Page<Role> page = new Page<Role>();
        page = authService.paginateRole(page);
        model.addAttribute("page", page);
        return "auth/role/role_manager";
    }

}
