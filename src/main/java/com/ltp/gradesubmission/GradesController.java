package com.ltp.gradesubmission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradesController {

    @GetMapping("/grades")
    public String getGrades(){
        return "grades"; // Directs the grades.html
    }
}
