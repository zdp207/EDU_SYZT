package com.syzton.sunread.repository.user;

import com.syzton.sunread.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 3/16/15.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}