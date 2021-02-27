package herogate.ggwp.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import herogate.ggwp.dao.TwitchDao;
import herogate.ggwp.domain.AuthToken;
import herogate.ggwp.domain.Clip;
import herogate.ggwp.domain.Game;
import herogate.ggwp.domain.TopGame;
import herogate.ggwp.repository.AuthTokenRepository;
import herogate.ggwp.repository.ClipRepository;
import herogate.ggwp.repository.GameRepository;
import herogate.ggwp.repository.TopGameRepository;

@Service
public class TwitchApiService implements ApiService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// TODO Class 분리
	public final static String GET_CLIPS_URL = "https://api.twitch.tv/helix/clips?game_id=";
	public final static String GET_TOPGAMES_URL = "https://api.twitch.tv/helix/games/top";

	@Value("${twitch_api_client_id}")
	String TWITCH_API_CLIENT_ID;

	@Value("${twitch_api_get_clips}")
	String TWITCH_API_GET_CLIPS;

	@Value("${twitch_api_get_games_top}")
	String TWITCH_API_GET_GAMES_TOP;

	@Value("${twitch_api_version_name}")
	String TWITCH_API_VERSION_NAME;

	@Autowired
	TwitchDao twitchDao;
	@Autowired
	ClipRepository clipRepo;

	@Autowired
	AuthTokenRepository authTokenRepo;
	@Autowired
	GameRepository gameRepo;
	@Autowired
	TopGameRepository topGameRepo;

	@Override
	public void getClipse() throws IOException {
		String gameId = "";

		List<Game> gameList = gameRepo.findAll();
		/*
		 * gameId 쿼리에서 가져오도록 변경함 ArrayList<String> gameIdList = new ArrayList<String>();
		 * gameIdList.add("493057"); //pubg gameIdList.add("460630"); //rainbowSix
		 * gameIdList.add("513143"); //Tft gameIdList.add("21779"); //leagueOflegends
		 * gameIdList.add("33214"); //Fortnite gameIdList.add("29595"); //dota2
		 * gameIdList.add("497057"); //desetiny 2 gameIdList.add("514790"); //Legends of
		 * Runeterra
		 */
		HttpURLConnection conn = null;
		URL url = null;
		BufferedReader accessTokenResult = null;
		String API_VERSION = "";
		String tempAuthToken = "";
		tempAuthToken = this.getToken();

		for (int k = 0; k < gameList.size(); k++) {
			gameId = String.valueOf(gameList.get(k).getIdx());
			try {
				LocalDate localNowdate = LocalDate.now();
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String today = localNowdate.minus(Period.ofWeeks(1)).format(dateTimeFormatter) + "T00:00:00Z";
				String started_at = "&started_at=" + today;
				url = new URL(TWITCH_API_GET_CLIPS + gameId + started_at);

				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Cache-Control", "no-cache");
				conn.setRequestProperty("Client-ID", TWITCH_API_CLIENT_ID);
				conn.setRequestProperty("Authorization", tempAuthToken);
				conn.setDoInput(true);
				conn.setDoOutput(true);

				accessTokenResult = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

				String responseStr = "";
				String jsonStr = "";
				while ((responseStr = accessTokenResult.readLine()) != null) {
					jsonStr += responseStr;
				}

				conn.disconnect();

				if (!("").equals(jsonStr)) {
					// JSON 파싱
					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode jsonNode = objectMapper.readTree(jsonStr);
					JsonNode jsonData = jsonNode.get("data");

					for (int j = 0; j < jsonData.size(); j++) {
						JsonNode json = jsonData.get(j);
						String clipId = json.get("id").asText();
						String language = json.get("language").asText();
						/*
						 * if(!"ko".equals(language)) { continue; }
						 */
						String title = json.get("title").asText();
						String embed_url = json.get("embed_url").asText();
						String video_id = json.get("video_id").asText();
						String game_id = json.get("game_id").asText();
						String broadcaster_id = json.get("broadcaster_id").asText();
						String creator_id = json.get("creator_id").asText();
						String created_at = json.get("created_at").asText();
						String thumbnail_url = json.get("thumbnail_url").asText();
						String view_count = json.get("view_count").asText();

						try {
							clipRepo.save(Clip.builder().clipId(clipId).url(embed_url).embed_url(embed_url)
									.broadcaster_id(broadcaster_id).creator_id(creator_id).created_at(created_at)
									.video_id(video_id).game_id(game_id).language(language).title(title)
									.view_count(view_count).thumbnail_url(thumbnail_url).build());
						} catch (Exception e) {
							continue;
						}

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
				logger.error("### ERROR ###");
				conn.disconnect();
				accessTokenResult.close();
			}
		}
	}

	@Override
	public List<Map<String, Object>> getTwitchClipsList() {
		return twitchDao.selectTwitchClipsList();
	}

	@Override
	public void getTopGamesCollet() throws IOException {
		// TODO Games/top API insert DB
		HttpURLConnection conn = null;
		URL url = null;
		BufferedReader accessTokenResult = null;
		String tempAuthToken = "";
		tempAuthToken = this.getToken();

		try {
			url = new URL(TWITCH_API_GET_GAMES_TOP);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Client-ID", TWITCH_API_CLIENT_ID);
			conn.setRequestProperty("Authorization", tempAuthToken);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			accessTokenResult = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			String responseStr = "";
			String jsonStr = "";
			while ((responseStr = accessTokenResult.readLine()) != null) {
				jsonStr += responseStr;
			}
			conn.disconnect();

			if (!("").equals(jsonStr)) {
				// JSON 파싱
				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readTree(jsonStr);
				JsonNode jsonData = jsonNode.get("data");

				topGameRepo.deleteAll();
				for (int j = 0; j < jsonData.size(); j++) {
					JsonNode json = jsonData.get(j);
					Long id = Long.parseLong(json.get("id").asText());
					String name = json.get("name").asText();
					String box_art_url = json.get("box_art_url").asText();

					gameRepo.save(Game.builder().idx(id).name(name).boxArtUrl(box_art_url).build());

					topGameRepo.save(TopGame.builder().idx(id).name(name).boxArtUrl(box_art_url).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("### ERROR ###");
			conn.disconnect();
			accessTokenResult.close();
		}
	}

	public void getTopGames() {

	}

	public void getTwitchToken() {

	}

	@Override
	public String getToken() throws IOException {
		Optional<AuthToken> temptoken = authTokenRepo.findTop1ByOrderByIdxDesc();

		if (temptoken.isPresent()) {
			return TWITCH_API_VERSION_NAME + " " + temptoken.get().getToken();
		} else {
			return null;
		}
	}
}
