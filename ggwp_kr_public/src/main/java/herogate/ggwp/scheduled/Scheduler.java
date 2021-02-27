package herogate.ggwp.scheduled;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import herogate.ggwp.api.TwitchApiService;

@Component
public class Scheduler {
	@Autowired
	TwitchApiService twitchApiService;

//	@Scheduled(cron="0 0 9 ? * MON,TUE,WED,THU,FRI")
	@Scheduled(fixedRate = 360000)
	public void getClipse() throws IOException {
		twitchApiService.getClipse();
	}

	@Scheduled(fixedRate = 180000)
	public void getGames() throws IOException {
		twitchApiService.getTopGamesCollet();
	}

	/*
	 * @Scheduled(fixedRate = 180000) public void getToken() throws IOException {
	 * twitchApiService.getTwitchToken(); }
	 */

}
