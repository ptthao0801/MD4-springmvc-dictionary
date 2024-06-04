package com.codegym.springmvcdictionarybaitap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DicController {
    private static final Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("computer", "máy tính");
        dictionary.put("programming", "lập trình");
        dictionary.put("language", "ngôn ngữ");
    }

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("form");
    }

    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam("word") String word) {
        ModelAndView modelAndView = new ModelAndView("result");
        String translation = dictionary.get(word.toLowerCase());
        if (translation != null) {
            modelAndView.addObject("word", word);
            modelAndView.addObject("translation", translation);
        }
        else {
            modelAndView.addObject("word", word);
            modelAndView.addObject("translation", "Not found!");
        }
        return modelAndView;
    }
}
