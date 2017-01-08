package com.lebao.dao.user;



import com.lebao.po.UserDepartmentRel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDepartmentRelRepo extends JpaRepository<UserDepartmentRel,Long> {
    List<UserDepartmentRel> findByUid(Long uid);
}
