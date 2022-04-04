package com.example.demo11.Web;

import com.example.demo11.Entite.Patient;
import com.example.demo11.Reposetories.PaitientReposetory;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Date;

@Controller
@AllArgsConstructor

public class ContrlerPatient {
    private PaitientReposetory paitientReposetory;

    @GetMapping(path="/user/index")
    public String patiates(Model model ,
                           @RequestParam(name ="page" ,defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue ="") String keyword)

    {
        Page<Patient> pagePatient= paitientReposetory.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("PagePtient",pagePatient.getContent());
        model.addAttribute("nombrePages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patient";
    }
    @GetMapping("/Admin/delete")
    public String delete(long id,String keyword,int page){
        paitientReposetory.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/Admin/formepatient")

    public String formepatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formepatient";
    }
    @PostMapping(path = "/Admin/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formepatient";
        paitientReposetory.save(patient);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping(path = "/Admin/editPtient")
    public String editPtient(Model model ,Long id ,String keyword,int page){
        Patient patient=paitientReposetory.findById(id).orElse(null);
        if(patient==null) new RuntimeException("patient nxicte pas");
        model.addAttribute("patient",patient);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);

        return "editepatient";

    }
    @GetMapping("/")
    public String Home(){
        return "index";
    }

}
