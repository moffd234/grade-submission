package com.ltp.gradesubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradesController {
    List<Grade> studentGrades = new ArrayList<>();

 
    @GetMapping("/grades")
    public String getGrades(Model model){

        model.addAttribute("grades", studentGrades);
        return "grades"; // Directs the grades.html
    }
    @GetMapping("/")
    public String gradeForm(Model model){
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String handleSubmit(Grade grade){
        studentGrades.add(grade); // Adds the grade that was submitted in the POST request
        return "redirect:/grades"; // Redirects to a GET request at /grades
    }
}
