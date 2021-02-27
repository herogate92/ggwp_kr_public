package herogate.ggwp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Deprecated
public class TwitchDao {
	protected static final String NAMESPACE = "ggwp.twitch.";

	@Autowired
	private SqlSession sqlSession;

	public List<Map<String, Object>> selectTwitchClipsList() {
		return sqlSession.selectList(NAMESPACE + "selectTwitchClip");
	}

	public int insertTwitchClip(Map<String, Object> paramMap) {
		return sqlSession.insert(NAMESPACE + "insertTwitchClip", paramMap);
	}
}