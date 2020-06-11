package controller;

import model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("counter")
@RequestMapping("/")
public class CounterController {

    @ModelAttribute("counter")
    public MyCounter myCounter(){
        return new MyCounter();
    }

    @GetMapping()
    public ModelAndView showForm(@ModelAttribute("counter") MyCounter counter){
        counter.increase();
        return new ModelAndView("showForm","counter",counter);
    }
}
