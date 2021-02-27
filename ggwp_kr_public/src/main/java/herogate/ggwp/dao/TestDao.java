package herogate.ggwp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Deprecated
public class TestDao {
	protected static final String NAMESPACE = "ggwp.test.";

	@Autowired
	private SqlSession sqlSession;

	public String selectName() {
		return sqlSession.selectOne(NAMESPACE + "selectName");
	}

	public List<Map<String, Object>> selectList() {
		return sqlSession.selectList(NAMESPACE + "selectList");
	}
}