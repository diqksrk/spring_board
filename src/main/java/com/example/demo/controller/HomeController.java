package com.example.demo.controller;

import java.util.Locale;

import com.example.demo.service.HomePageService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
@AllArgsConstructor
public class HomeController {
    /**
     * Simply selects the home view to render by returning its name.
     */
    private HomePageService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        log.info("Welcome home! The client locale is {}.", locale);

        model.addAttribute("boardList", service.getTitleOfBoard("tbl_board"));
        model.addAttribute("humorList", service.getTitleOfBoard("tbl_humor"));
        model.addAttribute("noticeList", service.getTitleOfBoard("tbl_notice"));

//        Date date = new Date();
//        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//        String formattedDate = dateFormat.format(date);
//
//        model.addAttribute("serverTime", formattedDate );

        return "home";
    }

    @GetMapping("/login")
    public String loginForm(HttpServletRequest req){
        String referer = req.getHeader("Referer");
        req.getSession().setAttribute("prevPage", referer);
        return "login";
    }

}
