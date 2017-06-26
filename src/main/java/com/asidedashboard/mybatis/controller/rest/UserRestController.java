package com.asidedashboard.mybatis.controller.rest;

import com.asidedashboard.mybatis.model.User;
import com.asidedashboard.mybatis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String dashboard(ModelMap modelMap) {
        modelMap.addAttribute("COUNTUSER", userService.countUser());
        modelMap.addAttribute("COUNTMALE", userService.countGender("M"));
        modelMap.addAttribute("COUNTFEMALE", userService.countGender("F"));
        return "admin/dashboard";
    }

    @RequestMapping("/admin/user-cu")
    public String createUser(ModelMap modelMap) {
        modelMap.addAttribute("USER", new User());
        return "admin/user-cu";
    }

    @RequestMapping("/admin/user-list")
    public String getUser(ModelMap modelMap) {
        List<User> users = userService.getUser();
        modelMap.addAttribute("USERS", users);
        return "admin/user-list";
    }

    @RequestMapping("/admin/user/{id}/detail")
    public String getUserByHash(@PathVariable String id, ModelMap modelMap) {
        modelMap.addAttribute("USERSBYHASH", userService.getUserByHash(id));
        return "admin/user-detail";
    }

    @RequestMapping(value = "/admin/user/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable String id, ModelMap modelMap) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/admin/user-list");
    }

    @RequestMapping(value = "/api/user/create", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return new ModelAndView("redirect:/admin/user-list");
    }

    @RequestMapping("/admin/user/{id}/update")
    public String updateUser(@PathVariable String id, ModelMap modelMap) {
        modelMap.addAttribute("USER", userService.getUserByHash(id));
        return "admin/user-up";
    }

    @RequestMapping(value = "/api/user/update", method = RequestMethod.POST)
    public ModelAndView updateUserByUserHash(@ModelAttribute User user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/admin/user-list");
    }

    @RequestMapping("/admin/role-cu")
    public String roleCreate() {
        return "admin/role-cu";
    }

    @RequestMapping("/admin/role-list")
    public String roleList() {
        return "admin/role-list";
    }
}
