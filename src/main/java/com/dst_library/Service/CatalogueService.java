package com.dst_library.Service;

import com.dst_library.Entity.Catalogue;
import com.dst_library.Repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {

    @Autowired
    private CatalogueRepository catalogueRepository;

    @Async
    public List<Catalogue> getAll() {
        return catalogueRepository.findAll();
    }

    @Async
    public Catalogue getById(Long idCatalogue) {
        return catalogueRepository.findById(idCatalogue).orElse(null);
    }

    @Async
    public void create(Catalogue catalogue) {
        catalogueRepository.save(catalogue);
    }

    @Async
    public void delete(Long idCatalogue) {
        catalogueRepository.deleteById(idCatalogue);
    }

    @Async
    public void update(Catalogue catalogue) {
        Catalogue _catalogue = getById(catalogue.getIdCatalogue());
        _catalogue.setBook(catalogue.getBook());
        _catalogue.setGenre(catalogue.getGenre());
        _catalogue.setKeywords(catalogue.getKeywords());

        catalogueRepository.save(_catalogue);
    }

}
