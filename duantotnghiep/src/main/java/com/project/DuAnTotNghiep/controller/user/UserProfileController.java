package com.project.DuAnTotNghiep.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {
    @GetMapping("/profile")
    public String viewProfilePage(Model model) {
        return "/user/profile";
    }
}
