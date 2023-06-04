package com.dst_library.Service;

import com.dst_library.Entity.Reader;
import com.dst_library.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Async
    public List<Reader> getAll() {
        return readerRepository.findAll();
    }

    @Async
    public Reader getById(Long idReader) {
        return readerRepository.findById(idReader).orElse(null);
    }

    @Async
    public void create(Reader reader) {
        readerRepository.save(reader);
    }

    @Async
    public void delete(Long idReader) {
        readerRepository.deleteById(idReader);
    }

    @Async
    public void update(Reader reader) {
        Reader _reader = getById(reader.getIdReader());
        _reader.setCardNumber(reader.getCardNumber());
        _reader.setGender(reader.getGender());
        _reader.setProfession(reader.getProfession());
        _reader.setFullName(reader.getFullName());
        _reader.setCheckInDate(reader.getCheckInDate());
        _reader.setCheckOutDate(reader.getCheckOutDate());
        _reader.setPassportData(reader.getPassportData());
        _reader.setYearOfBirth(reader.getYearOfBirth());

        readerRepository.save(_reader);
    }
}
