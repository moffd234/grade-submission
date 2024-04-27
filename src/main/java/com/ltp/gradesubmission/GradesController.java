package com.ltp.gradesubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradesController {
    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/grades")
    public String getGrades(Model model){
        studentGrades.add(new Grade("Harry", "Potions", "C-"));
        studentGrades.add(new Grade("Hermione", "DADA", "A+"));
        studentGrades.add(new Grade("Neville", "Charms", "A-"));

        model.addAttribute("grades", studentGrades);
        return "grades"; // Directs the grades.html
    }
}
