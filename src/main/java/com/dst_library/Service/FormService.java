package com.dst_library.Service;

import com.dst_library.Entity.Form;
import com.dst_library.Repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Async
    public List<Form> getAll() {
        return formRepository.findAll();
    }

    @Async
    public Form getById(Long idForm) {
        return formRepository.findById(idForm).orElse(null);
    }

    @Async
    public void create(Form form) {
        formRepository.save(form);
    }

    @Async
    public void delete(Long idForm) {
        formRepository.deleteById(idForm);
    }

    @Async
    public void update(Form form) {
        Form _form = getById(form.getIdForm());
        _form.setCopy(form.getCopy());
        _form.setReader(form.getReader());
        _form.setDateOfIssue(form.getDateOfIssue());
        _form.setDateOfReturn(form.getDateOfReturn());

        formRepository.save(_form);
    }

}
