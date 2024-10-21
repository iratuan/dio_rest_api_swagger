package br.com.dio.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.api.model.User;
import br.com.dio.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> all(){
        return repository.all();
    }

    public Optional<User> get(Long id){
        return repository.get(id);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.delete(id);
    }

}
