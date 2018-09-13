package com.sismiop.sismiop.service;

import com.sismiop.sismiop.model.Spop;
import com.sismiop.sismiop.repository.SpopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpopService implements ModelService<Spop, Long>{
    @Autowired
    private SpopRepository spopRepository;

    @Override
    public boolean add(Spop spop) {
        try{
            spopRepository.save(spop);
            return  true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean addAll(Iterable<Spop> spops) {
        try{
            spopRepository.saveAll(spops);
            return  true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Spop spop) {
        return add(spop);
    }

    @Override
    public boolean delete(Long aLong) {
        try{
            Spop spop = spopRepository.findSpopById(aLong);
            spop.setPermohonanOp(null);
            spopRepository.delete(spop);
            return  true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Spop getById(Long aLong) {
        return spopRepository.findSpopById(aLong);
    }
}
