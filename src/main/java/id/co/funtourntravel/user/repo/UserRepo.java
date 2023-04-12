package id.co.funtourntravel.user.repo;

import id.co.funtourntravel.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findUserById(Integer i);
    public User findUserByUserId(String userId);
}
