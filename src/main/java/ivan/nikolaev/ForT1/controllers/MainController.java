package ivan.nikolaev.ForT1.controllers;

import ivan.nikolaev.ForT1.service.IHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private IHandlerService handlerService;

    @GetMapping("/")
    public String show() {
        return "mainPage";
    }

    @PostMapping("/answer")
    public String getInputString(@RequestParam("str") String str, Model model) {
        model.addAttribute("string", str);
        model.addAttribute("dao", handlerService.mapToString(handlerService.countOfSymb(str)));
        return "mainPage";
    }
}
