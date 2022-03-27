package com.example.demo11.Web;

import com.example.demo11.Entite.Patient;
import com.example.demo11.Reposetories.PaitientReposetory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@AllArgsConstructor

public class ContrlerPatient {
    private PaitientReposetory paitientReposetory;
    @GetMapping(path="/Home")
    public String patiates(Model model ,
                           @RequestParam(name ="page" ,defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size)

    {
        Page<Patient> pagePatient= paitientReposetory.findAll(PageRequest.of(page,size));
        model.addAttribute("PagePtient",pagePatient.getContent());
        model.addAttribute("nombrePages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patient";
    }
    @GetMapping(path="/index")
    public String patiates(Model model ,
                           @RequestParam(name ="page" ,defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue ="") String keyword,
                           @RequestParam(name = "scor",defaultValue ="") int scor)

    {
        Page<Patient> pagePatient= paitientReposetory.findByNomContainsAndScoreEquals(keyword,scor,PageRequest.of(page,size));
        model.addAttribute("PagePtient",pagePatient.getContent());
        model.addAttribute("nombrePages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        model.addAttribute("scor",scor);
        return "patient";
    }
    @GetMapping("/delete")
    public String delete(long id,String keyword,int page,int scor){
        paitientReposetory.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword+"&scor="+scor;
    }
    @GetMapping("/")
    public String Home(){
        return "redirect:/Home";
    }



}
