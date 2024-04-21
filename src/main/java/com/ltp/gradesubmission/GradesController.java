package com.ltp.gradesubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradesController {

    @GetMapping("/grades")
    public String getGrades(Model model){
        Grade grade = new Grade("Harry", "Potions", "C-");
        model.addAttribute("grade", grade);
        return "grades"; // Directs the grades.html
    }
}
