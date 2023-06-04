package com.dst_library.Service;

import com.dst_library.Entity.Copy;
import com.dst_library.Repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    @Async
    public List<Copy> getAll() {
        return copyRepository.findAll();
    }

    @Async
    public Copy getById(Long idCopy) {
        return copyRepository.findById(idCopy).orElse(null);
    }

    @Async
    public void create(Copy copy) {
        copyRepository.save(copy);
    }

    @Async
    public void delete(Long idCopy) {
        copyRepository.deleteById(idCopy);
    }

    @Async
    public void update(Copy copy) {
        Copy _copy = getById(copy.getIdCopy());
        _copy.setBook(copy.getBook());
        _copy.setBranch(copy.getBranch());
        _copy.setQualityState(copy.getQualityState());
        _copy.setShelfCoordinate(copy.getShelfCoordinate());
        _copy.setStorageRoomNumber(copy.getStorageRoomNumber());
        _copy.setYearOfRelease(copy.getYearOfRelease());

        copyRepository.save(_copy);
    }

}
