package com.lebao.modules.adv.dao;

import com.lebao.bean.AdvSearchParam;
import com.lebao.common.dbhelp.DbHelper;
import com.lebao.common.dbhelp.page.Page;
import com.lebao.common.utils.Sequence;
import com.lebao.common.utils.TimeUtil;
import com.lebao.modules.adv.entity.AdvEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class AdvDao {
	@Resource(name="dbHelper")
	private DbHelper dbHelper;

	public void addAdv(AdvEntity ae) throws SQLException {
		String p_id = Sequence.nextId();
		String p_goods_id = ae.getP_goods_id();
		String p_title = ae.getP_title();
		String p_content = ae.getP_content();
		String p_photo = ae.getP_photo();
		String p_url = ae.getP_url();
		String p_type =ae.getP_type();
		String p_status = ae.getP_status();
		String p_create_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
		String sql = "INSERT INTO t_adv(p_id,p_goods_id,p_title,p_content,p_photo,p_url,p_type,p_status,p_create_time) VALUES(?,?,?,?,?,?,?,?,?)";
		dbHelper.execute(sql, p_id, p_goods_id, p_title, p_content, p_photo, p_url, p_type, p_status, p_create_time);
	}
	public List<AdvEntity> getAdvs() throws SQLException {
		String sql = "select * from t_adv where p_status='1' ";
		return dbHelper.getBeanList(sql,AdvEntity.class);
	}

	public Page<AdvEntity> getAdvs(AdvSearchParam s) throws SQLException {
		String sql = "select * from t_adv where 1=1";
		if (StringUtils.isNotBlank(s.getType())) {
			sql += " and p_name  like '" + s.getType() + "%' ";
		}
		sql += " order by " + s.getSortField() + "  " + s.getSortType() + " ";
		return dbHelper.getPage(sql, AdvEntity.class, s.getPageNow(), s.getPageSize());
	}


	public AdvEntity getAdvById(String advId) throws SQLException {
		String sql = "select * from t_adv where t_adv.p_id=?";
		return dbHelper.getBean(sql, AdvEntity.class, advId);
	}

	public void updAdv(AdvEntity ae) throws SQLException {
		String p_id = ae.getP_id();
		String p_goods_id = ae.getP_goods_id();
		String p_title = ae.getP_title();
		String p_content = ae.getP_content();
		String p_photo = ae.getP_photo();
		String p_url = ae.getP_url();
		String p_type =ae.getP_type();
		String p_update_time = TimeUtil.format(new Date(), TimeUtil.TARGET_1);
		String sql = "update t_adv set p_goods_id=?,p_title=?,p_content=?,p_photo=?,p_url=?,p_type=?,p_update_time=? where p_id=?";
		dbHelper.execute(sql, p_goods_id, p_title, p_content, p_photo, p_url, p_type,p_update_time, p_id);
	}

	public void delAdv(String advId) throws SQLException {
		String sql = "update t_adv set p_status='-1' where p_id = ?";
		dbHelper.execute(sql, advId);
	}


	public void reAddAdv(String advId) throws SQLException {
		String sql = "update t_adv set p_status = '1' where p_id=?";
		dbHelper.execute(sql, advId);
	}

}
