package org.itstep.thymeleaf.smart;

import org.itstep.thymeleaf.firm.FirmService;
import org.itstep.thymeleaf.os.Os;
import org.itstep.thymeleaf.os.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

    @Controller
    public class SmartController {
        @Autowired
        private SmartService smartService;

        @Autowired
        private FirmService firmService;

        @Autowired
        private OsService osService;

        @GetMapping(value="/smarts")
        public String smarts(Model model){
            model.addAttribute("smarts", smartService.findAll());
            return "smarts";
        }

        @GetMapping(value="/smart_add")
        public String smartAdd(Model model){
            model.addAttribute("smart", new Smart());
            model.addAttribute("firms", firmService.findAll());
            model.addAttribute("oss", osService.findAll());
            return "smart_add";
        }

        // - ОСТАНОВИЛИСЬ ТУТО!!!

        @PostMapping(value = "/os_add")
    public String osSave(Os os, Model model, HttpServletResponse response) {
        Os newOs = osService.save(os);
        long id = newOs.getId();
        response.addHeader("id", String.valueOf(id));
        model.addAttribute("oss", osService.findAll());
        return "redirect:/oss";
    }

    @DeleteMapping(value = "/os_delete")
    public String osDelete(@RequestParam(name = "id") Long id) {
        osService.deleteById(id);
        return "redirect:/oss";
    }

    @GetMapping(value = "/os_update")
    public String osGetUpdate(Model model, @RequestParam(name = "id") Long id) {
        Os oldOs = osService.findById(id);
        model.addAttribute("os", oldOs);
        return "/os_update";
    }

    @PutMapping(value = "/os_update")
    public String osUpdate(Os os, Model model) {
        Os oldOs = osService.findById(os.getId());
        oldOs.setName(os.getName());
        oldOs.setDeveloper(os.getDeveloper());
        osService.save(oldOs);
        model.addAttribute("oss", osService.findAll());
        return "redirect:/oss";
    }
}
