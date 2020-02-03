package pl.jakubczubak.app.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessDeniedController {
    @GetMapping("/403")
    public String getAccessDeniedPage() {
        return "403";
    }
}
