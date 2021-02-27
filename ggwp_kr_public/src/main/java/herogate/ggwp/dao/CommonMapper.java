package herogate.ggwp.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Deprecated
public class CommonMapper {
		@Autowired
		private SqlSession sqlSession;
}
