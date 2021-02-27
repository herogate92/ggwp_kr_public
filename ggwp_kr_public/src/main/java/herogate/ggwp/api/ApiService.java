package herogate.ggwp.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ApiService {

	void getClipse() throws IOException;

	List<Map<String, Object>> getTwitchClipsList();
	
	void getTopGamesCollet() throws IOException;
	
	String getToken() throws IOException;

}
