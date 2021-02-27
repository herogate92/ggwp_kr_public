package herogate.ggwp;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import herogate.ggwp.api.TwitchApiService;
import herogate.ggwp.repository.GameRepository;
import herogate.ggwp.repository.TopGameRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GgwpApplicationTests 
{

	@Autowired GameRepository gameRepo;
	@Autowired TopGameRepository topGameRepo;
	@Autowired TwitchApiService twitchApiService;
	@Test
	public void contextLoads() throws IOException {
		twitchApiService.getTopGamesCollet();
	}
	
	@Test
	public void jpatest() throws IOException {
		System.out.println(topGameRepo.findAll());
	}
	
//	@Test
	public void testdatetime()
	{
		LocalDate localdate = LocalDate.now().minusDays(1);
		localdate.minusDays(1);
		System.out.println(localdate.minusDays(1));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T' HH:mm:ss'Z'");
		String nowStr = localdate.minusDays(1).format(dateTimeFormatter);
		System.out.println("DEBUG###");
		System.out.println(nowStr);
	}

}


