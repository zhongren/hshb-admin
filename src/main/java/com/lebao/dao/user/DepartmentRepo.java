package com.lebao.dao.user;



import com.lebao.po.Department;
import com.lebao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {

}
