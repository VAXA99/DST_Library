package com.dst_library.Service;

import com.dst_library.Entity.User;
import com.dst_library.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Async
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Async
    public User getById(Long idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Async
    public void create(User user) {
        userRepository.save(user);
    }

    @Async
    public void delete(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Async
    public void update(User user) {
        User _user = getById(user.getIdUser());
        _user.setRole(user.getRole());
        _user.setLogin(user.getLogin());
        _user.setPassword(user.getPassword());

        userRepository.save(_user);
    }

}
