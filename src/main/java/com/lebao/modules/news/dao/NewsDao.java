//package com.lebao.modules.news.dao;
//
//import com.lebao.bean.NewsSearchParam;
//import com.lebao.common.dbhelp.DbHelper;
//import com.lebao.common.dbhelp.page.Page;
//import com.lebao.common.utils.Sequence;
//import com.lebao.common.utils.TimeUtil;
//import com.lebao.modules.news.entity.NewsEntity;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Resource;
//import java.sql.SQLException;
//import java.util.Date;
//
///**
// * Created by Server on 2016/4/1.
// */
//@Repository
//public class NewsDao {
//    @Resource(name = "dbHelper")
//    private DbHelper dbHelper;
//    public int add(NewsEntity ne) throws SQLException {
//        String p_id = Sequence.nextId();
//        String p_type_id = ne.getP_type_id();
//        String p_user_id=ne.getP_user_id();
//        String p_title = ne.getP_title();
//        String p_htmlPart = ne.getP_htmlPart();
//       // String p_browseTime=ne.getP_browseTime();
//        String p_photo1=ne.getP_photo1();
//        String p_photo2=ne.getP_photo2();
//        String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
//        String p_url = ne.getP_url();
//        String p_status = ne.getP_status();
//        System.out.println(ne.toString());
//        String sql = "INSERT INTO t_news(p_id,p_type_id,p_user_id,p_title,p_htmlPart,p_photo1, p_photo2,p_create_time,p_url,p_status) VALUES(?,?,?,?,?,?,?,?,?,?)";
//        return dbHelper.execute(sql, p_id, p_type_id, p_user_id, p_title, p_htmlPart, p_photo1, p_photo2, p_create_time, p_url, p_status);
//    }
//
//    public int delete(String p_id,String p_state) throws SQLException {
//        String sql = "update t_news set p_status = ? where p_id=?";
//        return dbHelper.execute(sql,p_state, p_id);
//    }
//
//    public int update(NewsEntity ne) throws SQLException {
//        String p_id = ne.getP_id();
//        String p_user_id=ne.getP_user_id();
//        String p_title = ne.getP_title();
//        String p_htmlPart = ne.getP_htmlPart();
//        String p_photo1=ne.getP_photo1();
//        String p_photo2=ne.getP_photo2();
//        String p_update_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
//        String p_url = ne.getP_url();
//        String p_status = ne.getP_status();
//        String sql = "update t_news set p_user_id = ?,p_title = ?, p_htmlPart=?,p_photo1=?,p_photo2=?,p_update_time=?,p_url=?,p_status=? where p_id=?";
//        return dbHelper.execute(sql, p_user_id, p_title, p_htmlPart, p_photo1, p_photo2, p_update_time, p_url, p_status, p_id);
//    }
//
//    public NewsEntity getNewsEntity(String p_id) throws SQLException {
//        String sql = "select * from t_news  where p_id=?";
//        return dbHelper.getBean(sql, NewsEntity.class, p_id);
//    }
//
//    /*
//    SELECT t_goods_type.p_type_name , t_goods.*
//FROM t_goods
//JOIN t_goods_type
//ON t_goods_type.p_id=t_goods.p_type_id
//     */
//    public Page<NewsEntity> getNewsEntitys(NewsSearchParam s) throws SQLException {
//        String sql = " SELECT t_type.p_type_name , t_news.*\n" +
//                " FROM t_news\n" +
//                " JOIN t_type\n" +
//                " ON t_type.p_id=t_news.p_type_id ";
//
//        if( StringUtils.isNotBlank(s.getTitle())){
//            sql +=" and t_news.p_name like  '%"+s.getTitle()+"%' ";
//        }
//        sql +=" and t_news.p_status !=-1";
//       // System.out.println(sql);
//        return dbHelper.getPage(sql, NewsEntity.class, s.getCurPage(),s.getPageSize());
//
//    }
//
//}
