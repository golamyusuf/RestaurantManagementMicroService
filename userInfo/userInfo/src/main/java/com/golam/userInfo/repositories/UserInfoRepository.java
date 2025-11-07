package com.golam.userInfo.repositories;

import com.golam.userInfo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer> {

}
