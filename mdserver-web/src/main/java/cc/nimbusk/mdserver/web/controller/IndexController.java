package cc.nimbusk.mdserver.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main index controller
 *
 * @author nimbusk
 * @version 1.0
 * @date 2022/1/19
 */
@RestController
@RequestMapping("/mdserver")
@Slf4j
public class IndexController {

    @GetMapping("/index")
    public ModelAndView mainIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
