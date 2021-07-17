package com.example.studysecurity.form;

import com.example.studysecurity.account.AccountContext;
import com.example.studysecurity.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/")
    public String index (Model model, Principal principal){

        if(principal == null){
            model.addAttribute("message", "hello strager!");
        } else {
            model.addAttribute("message", "hello! " + principal.getName());
        }
        return "index";
    }

    @GetMapping("/info")
    public String info (Model model){
        model.addAttribute("message", "info");
        return "info";
    }

    @GetMapping("/admin")
    public String admin (Model model, Principal principal){
        model.addAttribute("message", "hello admin, " + principal.getName());
        return "admin";
    }

    @GetMapping("/dashBoard")
    public String dashBoard (Model model, Principal principal){
        model.addAttribute("message", "hello, " + principal.getName()) ;
        AccountContext.setAccount(accountRepository.findByUsername(principal.getName()));
        sampleService.dashboard();
        return "dashBoard";
    }



}
