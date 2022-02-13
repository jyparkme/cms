package com.cms.controller;

import com.cms.model.Clinic;
import com.cms.model.Health;
import com.cms.repository.ClinicRepository;
import com.cms.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private HealthRepository healthRepository;

    @Autowired
    private ClinicRepository clinicRepository;

/*    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 5)Pageable pageable, @RequestParam(required = false, defaultValue = "")String searchText) {

        Page<Health> healths = healthRepository.findByHealthNameContainingOrRegNumberContainingOrManagerNameContaining(searchText, searchText, searchText, pageable);
        int startPage = Math.max(1, healths.getPageable().getPageNumber() - 4);
        int endPage = Math.min(healths.getTotalPages(), healths.getPageable().getPageNumber() + 4);
        model.addAttribute("healths", healths);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("title", "헬스케어사");
        return "healthList";
    }*/

    @GetMapping("/health")
    public String healthList(Model model) {
        List<Health> healths = healthRepository.findAll();
        model.addAttribute("healths", healths);
        model.addAttribute("title", "헬스케어사");
        return "healthList";
    }

    @GetMapping("/clinic")
    public String clinicList(Model model) {
        List<Clinic> clinics = clinicRepository.findAll();
        model.addAttribute("clinics", clinics);
        model.addAttribute("title", "협력병원");
        return "clinicList";
    }

    @GetMapping("/healthClinic")
    public String healthClinic(Model model) {
        List<Health> healths = healthRepository.findAll();
        List<Clinic> clinics = clinicRepository.findAll();
        model.addAttribute("healths", healths);
        model.addAttribute("clinics", clinics);
        model.addAttribute("title", "병원연동");
        return "merge/healthClinic";
    }
}
