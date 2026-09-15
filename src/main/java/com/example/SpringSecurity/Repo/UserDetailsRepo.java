package com.example.SpringSecurity.Repo;

import com.example.SpringSecurity.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<Users,Integer> {

}
