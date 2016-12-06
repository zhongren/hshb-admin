//package com.lebao.service.impl;
//
//import com.lebao.bean.SysMenuBean;
//import com.lebao.bean.SysPermissionBean;
//import com.lebao.modules.permission.entity.SysPermissionEntity;
//import com.lebao.modules.sys.dao.SysDao;
//import com.lebao.modules.sys.entity.SysMenuEntity;
//import com.lebao.service.i.ISysService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class SysService implements ISysService {
//    @Autowired
//    private SysDao sysDao;
//
//    public List<SysMenuBean> getMenusByUserId(String userId) throws SQLException {
//        List<SysMenuBean> list = new ArrayList<SysMenuBean>();
//        List<SysMenuEntity> entities;
//        SysMenuBean smb;
//        entities = sysDao.getMenus(userId);
//        for (SysMenuEntity sme : entities) {
//            smb = new SysMenuBean();
//            BeanUtils.copyProperties(sme, smb);
//            list.add(smb);
//        }
//        return list;
//    }
//
//    public List<SysPermissionBean> getPermissionByUserId(String userId) throws SQLException {
//        List<SysPermissionBean> list = new ArrayList<SysPermissionBean>();
//        List<SysPermissionEntity> entities;
//        SysPermissionBean spb;
//        entities = sysDao.getPermissions(userId);
//        for (SysPermissionEntity spe : entities) {
//            spb = new SysPermissionBean();
//            BeanUtils.copyProperties(spe, spb);
//            list.add(spb);
//        }
//        return list;
//    }
//
//    public List<SysMenuBean> buildMenu(List<SysMenuBean> menus) {
//        List<SysMenuBean> list = new ArrayList<SysMenuBean>();
//        for (SysMenuBean m : menus) {
//            if (m.getP_fid().equals("0")) {
//                list.add(m);
//            }
//        }
//        for (SysMenuBean m : list) {
//            List<SysMenuBean> fmenus = new ArrayList<SysMenuBean>();
//            for (SysMenuBean m2 : menus) {
//                if (m2.getP_fid().equals(m.getP_id())) {
//                    fmenus.add(m2);
//                    m.setFmenus(fmenus);
//                }
//            }
//        }
//        return list;
//    }
//
//
//    /**
//     * 构建权限集合(shiro)
//     *
//     * @param userId
//     * @return
//     */
//    public Set<String> buildPermissionSetByUserId(String userId) {
//        Set<String> pudcPerms = null;
//        try {
//            List<SysPermissionBean> perms = getPermissionByUserId(userId);
//            List<SysMenuBean> menus = getMenusByUserId(userId);
//            pudcPerms = new HashSet<String>();
//            String url = "";
//            for (SysPermissionBean spb : perms) {
//                for (SysMenuBean smb : menus) {
//                    if (smb.getP_id().equals(spb.getP_sys_menu_id())) {
//                        url = smb.getP_url() + ":" + spb.getP_mapping();
//                    }
//                }
//                pudcPerms.add(url);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return pudcPerms == null ? new HashSet<String>() : pudcPerms;
//    }
//
//}
