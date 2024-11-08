package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("selectedSearchType", "all");
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

    @PostMapping(value = "results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {

        ArrayList<Job> jobs;

        if (searchTerm.equals("all")) {
            jobs = JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("title", "Jobs With All: " + searchTerm);
        model.addAttribute("selectedSearchType", searchType);

        if (jobs.isEmpty()) {
            model.addAttribute("title", "No jobs found for the Keyword: '" + searchTerm + "'. Please try a different keyword.");
        }

        return "search";
    }

}