package com.example.demo11.Web;

import com.example.demo11.Entite.Etudiant;
import com.example.demo11.Reposetories.EtudiantReposetory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@AllArgsConstructor

public class ContrlerEtudiant {
    private EtudiantReposetory EtdiantReposetory;

    @GetMapping(path="/user/index")
    public String patiates(Model model ,
                           @RequestParam(name ="page" ,defaultValue = "0") int page,
                           @RequestParam(name = "size",defaultValue = "5") int size,
                           @RequestParam(name = "keyword",defaultValue ="") String keyword)

    {
        
        Page<Etudiant> pageEtudiant= EtdiantReposetory.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("PageEtudiant",pageEtudiant.getContent());
        model.addAttribute("nombrePages",new int[pageEtudiant.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "Etudiant";
    }
    @GetMapping("/Admin/delete")
    public String delete(long id,String keyword,int page){
        EtdiantReposetory.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/Admin/formepatient")

    public String formepatient(Model model){
        model.addAttribute("etudiant",new Etudiant());
        return "formeEtudiant";
    }
    @PostMapping(path = "/Admin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()) return "formeEtudiant";
        EtdiantReposetory.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping(path = "/Admin/editEtudiant")
    public String editEtudiant(Model model , Long id , String keyword, int page){
        Etudiant etudiant= EtdiantReposetory.findById(id).orElse(null);
        if(etudiant==null) new RuntimeException("Eudiat nxicte pas");
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("keyword",keyword);
        model.addAttribute("page",page);

        return "editeEtudiant";

    }
    @GetMapping("/")
    public String Home(){
        return "index";
    }

}
