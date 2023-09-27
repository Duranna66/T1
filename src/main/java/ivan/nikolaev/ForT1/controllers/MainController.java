package ivan.nikolaev.ForT1.controllers;

import ivan.nikolaev.ForT1.service.HandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private HandlerService handlerService;

    @GetMapping("/")
    public String show() {
        return "mainPage";
    }
    @PostMapping("/answer")
    public String inputString(@RequestParam("str") String str, Model model) {
        String res = handlerService.mapToString(handlerService.countOfSymb(str));
        model.addAttribute("string", str);
        model.addAttribute("dao", res);
        return "mainPage";
    }
}
