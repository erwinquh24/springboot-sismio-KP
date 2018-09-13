package com.sismiop.sismiop.controller;

import com.sismiop.sismiop.model.Penduduk;
import com.sismiop.sismiop.model.PermohonanOp;
import com.sismiop.sismiop.model.Spop;
import com.sismiop.sismiop.service.PermohonanOpService;
import com.sismiop.sismiop.service.SpopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SpopController {

    @Autowired
    private PermohonanOpService permohonanOpService;
    @Autowired
    private SpopService spopService;


    @GetMapping({"/penduduk/permohonan-op/edit/{id}/register-spop"})
    public ModelAndView editPermohonanOp(@PathVariable("id") Long id) {
        ModelAndView m = new ModelAndView();
        m.addObject("subTitle", "Register SPOP");
        PermohonanOp permohonanOp = permohonanOpService.getById(id);
        if(permohonanOp.isStatus() && permohonanOp.getSpop() == null) {
            Spop spop = new Spop();
            spop.setPermohonanOp(permohonanOp);
            m.addObject("spopBaru", spop);
            m.setViewName("pages/penduduk/register-spop");
        }else {
            m.setViewName("redirect:/403");
        }
        return  m;
    }

    @PostMapping({"/penduduk/permohonan-op/edit/{id}/register-spop"})
    public ModelAndView simpanEditPermohonanOp(@PathVariable("id") Long id,
                                               @Valid @ModelAttribute("spopBaru") Spop spopBaru) {
        ModelAndView m = new ModelAndView();
        PermohonanOp pop = spopBaru.getPermohonanOp();
        pop.setSpop(spopBaru);
        if(id.equals(spopBaru.getId()) && spopService.add(spopBaru) && permohonanOpService.update(pop)) {
            m.addObject("msg", "sukses");
        }else
            m.addObject("msg", "gagal");
        m.setViewName("redirect:/dashboard");
        return m;
    }
}

