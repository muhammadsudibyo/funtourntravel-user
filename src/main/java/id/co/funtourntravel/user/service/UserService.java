package id.co.funtourntravel.user.service;

import id.co.funtourntravel.user.model.User;
import id.co.funtourntravel.user.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void insert(User user){
    userRepo.save(user);

    }

    @Transactional
    public String update(User user){
    User tempUser = userRepo.findUserByUserId(user.getUserId());
    if (tempUser!= null){
        user.setId(tempUser.getId());
        userRepo.save(user);
        return "User telah berhasil ditambahkan";
    } else{
        return "User tidak ditemukan";
    }
    }

    public  void delete(User user){
        userRepo.deleteById(user.getId());
    }

    public  User getUserById (User user){
        return userRepo.findUserById(user.getId());

    }

    public List getAllUser(){
        return userRepo.findAll();
    }
}
