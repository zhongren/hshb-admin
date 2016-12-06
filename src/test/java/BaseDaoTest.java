import java.sql.SQLException;

import com.lebao.common.utils.Sequence;
import com.lebao.modules.BaseDao;
import com.lebao.modules.user.entity.UserEntity;

/**
 * Created by Server on 2016/6/19.
 */
public class BaseDaoTest {

    public static void main( String [] ars ){
        BaseDao<UserEntity> userDao = new BaseDao<UserEntity>() ;
        UserEntity user = new UserEntity() ;
        String p_id = Sequence.nextId();
        user.setP_user_phone("1307339156");
        user.setP_state(1);
        user.setP_id(p_id);
        user.setP_account("大");
        try {
			//userDao.save(user);
        	userDao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
