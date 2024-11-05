package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController extends TechJobsController {

    @GetMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
}