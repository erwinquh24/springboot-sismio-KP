package com.sismiop.sismiop.controller;

import com.sismiop.sismiop.model.*;
import com.sismiop.sismiop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PendudukService pendudukService;

    @Autowired
    private JabatanService  jabatanService;
//    @Autowired
//    private PermohonanOpService permohonanOpService;
//
//    @Autowired
//    private PermohonanService permohonanService;

//    @GetMapping("permohonan-op-penduduk/daftar")
//    public ModelAndView getAllDaftarPermohonanOp(@PageableDefault(size = 15)Pageable pageable) {
//        ModelAndView m = new ModelAndView();
//        m.addObject("subTitle", "Daftar Permohonan OP Penduduk");
//        Page<PermohonanOp> page =  permohonanOpService.getAllPermohonan(pageable);
//        m.addObject("page", page);
//        m.setViewName("pages/admin/daftar-semua-permohonan-op");
//        return  m;
//    }



//    @GetMapping("permohonan-op-penduduk/setujui/{id}")
//    public ModelAndView setujuiPermohonanOp(@PathVariable("id") Long id) {
//        ModelAndView m = new ModelAndView();
//        if(updateStatusPermohonan(id, true)) {
//            m.addObject("msg", "Permohonan berhasil disetujui");
//        }else {
//            m.addObject("msg", "Permohonan Gagal di disetujui");
//
//        }
//        m.setViewName("redirect:/admin/permohonan-op-penduduk/daftar");
//        return  m;
//    }
//
//    @GetMapping("permohonan-op-penduduk/batal-menyetujui/{id}")
//    public ModelAndView batalMenyetujuiPermohonanOp(@PathVariable("id") Long id) {
//        ModelAndView m = new ModelAndView();
//        if(updateStatusPermohonan(id, false)) {
//            m.addObject("msg", "Permohonan berhasil disetujui");
//        }else {
//            m.addObject("msg", "Permohonan Gagal disetujui");
//
//        }
//        m.setViewName("redirect:/admin/permohonan-op-penduduk/daftar");
//        return  m;
//    }
//
//    private boolean updateStatusPermohonan(Long id, boolean status) {
//        PermohonanOp p = permohonanOpService.getById(id);
//        p.setStatus(status);
//        return permohonanOpService.add(p);
//    }

//    @GetMapping("permohonan-pengurangan-penduduk/setujui/{id}")
//    public ModelAndView setujuiPermohonanPengurangan(@PathVariable("id") Long id) {
//        ModelAndView m = new ModelAndView();
//        if(updateStatusPermohonanPengurangan(id, true)) {
//            m.addObject("msg", "Permohonan berhasil disetujui");
//        }else {
//            m.addObject("msg", "Permohonan Gagal di disetujui");
//
//        }
//        m.setViewName("redirect:/admin/permohonan-pengurangan-penduduk/daftar");
//        return  m;
//    }
//
//    @GetMapping("permohonan-pengurangan-penduduk/batal-menyetujui/{id}")
//    public ModelAndView batalMenyetujuiPermohonanPengurangan(@PathVariable("id") Long id) {
//        ModelAndView m = new ModelAndView();
//        if(updateStatusPermohonanPengurangan(id, false)) {
//            m.addObject("msg", "Permohonan berhasil disetujui");
//        }else {
//            m.addObject("msg", "Permohonan Gagal disetujui");
//
//        }
//        m.setViewName("redirect:/admin/permohonan-pengurangan-penduduk/daftar");
//        return  m;
//    }
//
//    private boolean updateStatusPermohonanPengurangan(Long id, boolean status) {
//        Permohonan p = permohonanService.getById(id);
//        p.setStatus(status);
//        return permohonanService.add(p);
//    }

//    @GetMapping("report")
//    public ModelAndView report (HttpServletRequest request, HttpServletResponse response){
//        String typeReport = request.getParameter("type");
//
//        Penugasan penugasan = null;
//
//        List<Penugasan> list=new ArrayList<Penugasan>();
//
//        list.add(new Penugasan(penugasan.getNoSurat(), penugasan.getNOP(), penugasan.getIsiSurat()));
//
//        if (typeReport!=null && typeReport.equals("pdf")){
//            return new ModelAndView(new ReportPDF(),"penugasanList",list);
//
//        }
//
//        return new ModelAndView("penugasanListReport","penugasanList",list);
//    }

    @GetMapping("tambah/pegawai/daftar")
    public ModelAndView getAllDaftarPegawai(@PageableDefault(size = 15)Pageable pageable) {
        ModelAndView m = new ModelAndView();
        m.addObject("subTitle", "Daftar Semua Penduduk");
        Page<Penduduk> page =  pendudukService.getAllPenduduk(pageable);
        m.addObject("tambahPenduduk", page);
        m.setViewName("pages/admin/tambah-pegawai");
        return  m;
    }

    @PostMapping(value = {"/permohonan/penugasan"})
    public ModelAndView savePenugasan(@Valid @ModelAttribute("penugasan") Jabatan jabatan, @Valid @ModelAttribute("authUser") Penduduk penduduk, BindingResult bindingResult) {
        ModelAndView m  = new ModelAndView();
        Penduduk p = new Penduduk();
        m.addObject("subTitle", "Daftar Surat Pengantar");
        m.addObject("penduduk", p);
        if(pendudukService.add(p) && jabatanService.addAll(p.getJabatans())) {
            m.addObject("success", true);
            m.setViewName("pages/admin/tambah-pegawai");
        }
        else {
            m.addObject("error", false);
            m.setViewName("pages/admin/tambah-pegawai");
        }
        return m;
    }

    //    private boolean updateStaff(Long id, boolean role) {
//        Permohonan p = permohonanService.getById(id);
//        p.setStatus(status);
//        return permohonanService.add(p);
//    }
}
