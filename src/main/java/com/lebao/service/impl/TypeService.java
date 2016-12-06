package com.lebao.service.impl;

import com.lebao.bean.SearchParam;
import com.lebao.bean.TypeBean;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.modules.type.dao.TypeDao;
import com.lebao.modules.type.entity.TypeEntity;
import com.lebao.service.i.ITypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private TypeDao typeDao;



    public TypeBean getTypeById(String p_id) throws SQLException {
        TypeEntity gte=typeDao.getType(p_id);
        TypeBean gtb=new TypeBean();
        BeanUtils.copyProperties(gte,gtb);
        return gtb;
    }

    public int delType(String p_id) throws SQLException {
        return  typeDao.delType(p_id);
    }

    public int addType(TypeBean gtb) throws SQLException {
        TypeEntity gte=new TypeEntity();
        BeanUtils.copyProperties(gtb,gte);
        return typeDao.addType(gte);
    }

    public int updType(TypeBean gtb) throws SQLException {
        TypeEntity gte=new TypeEntity();
        BeanUtils.copyProperties(gtb,gte);
        return typeDao.updType(gte);
    }

    public Page<TypeBean> getTypes(SearchParam s) throws SQLException {
        int myPageSize = 0;//每页记录数
        int curPage = 0;//显示页
        int pageCount = 0;//页数
        int recordCount = 0;//总记录数
        List<TypeBean> list = new ArrayList<TypeBean>();
        TypeBean tb = null;
        Page<TypeEntity> pageEntity = typeDao.getTypes(s);
        if(null!=pageEntity){
            List<TypeEntity>  listEntity = pageEntity.getData();
            for(TypeEntity te:listEntity){
                tb=  new TypeBean();
                BeanUtils.copyProperties(te, tb);
                if(te.getP_status().equals("1")){
                    tb.setP_status("已上架");
                }else {
                    tb.setP_status("已下架");
                }
                list.add(tb);
            }
            recordCount = pageEntity.getRecordCount();
            pageCount = pageEntity.getPageCount();
            curPage = pageEntity.getCurPage();
            myPageSize = pageEntity.getPageSize();
        }
        Page<TypeBean> pageBean = new Page<TypeBean>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public List<TypeBean> getTypes() throws SQLException {
        List<TypeEntity> entities=typeDao.getTypes();
        List<TypeBean> list=new ArrayList<TypeBean>();
        TypeBean tb;
        for(TypeEntity e:entities){
            tb=  new TypeBean();
            BeanUtils.copyProperties(e, tb);
            list.add(tb);
        }
        return list;
    }

    public void reAddType(String typeId) throws SQLException {
        typeDao.reAddType(typeId);
    }


}
