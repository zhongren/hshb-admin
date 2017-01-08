package com.lebao.po;

import javax.persistence.*;

/**
 * Created by ZR on 2017/1/8.
 */
@Entity
@Table(name="tb_user_department_rel")
public class UserDepartmentRel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long uid;
    private Long did;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public UserDepartmentRel(Long uid, Long did) {
        this.uid = uid;
        this.did = did;
    }

    public UserDepartmentRel() {
    }
}
