package herogate.ggwp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import herogate.ggwp.domain.Clip;
import herogate.ggwp.domain.Game;
import herogate.ggwp.domain.TopGame;
import herogate.ggwp.repository.ClipRepository;
import herogate.ggwp.repository.GameRepository;
import herogate.ggwp.repository.TopGameRepository;

/**
 * Restful api version 1
 * 
 * @author herogate92@gmail.com
 *
 */
@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = { "http://localhost:9081", "http://localhost:*", "https://ggwp.kr",
		"api-ggwp-kr.herokuapp.com" })
@RequestMapping("/api/v1")
public class ResfulApiContorller {
	@Autowired
	ClipRepository clipRepo;
	@Autowired
	GameRepository gameRepo;
	@Autowired
	TopGameRepository topGameRepo;

	@GetMapping("/clip/game/{gameId}") // @PathVariable 경로변수
	public List<Clip> getClipListByGameId(@PathVariable String gameId) {
		return clipRepo.findTop40ByGameIdOrderByIdxDesc(gameId);
	}

	@GetMapping("/get/clip")
	public List<Clip> getClip() {
//		Clip clip = Clip.builder().title(param.get("title")).game_id(param.get("game_id")).url(param.get("url")).build();
//		System.out.println(clip);
		return clipRepo.findTop40ByOrderByIdxDesc();
	}

	@PostMapping("/post/clip")
	public List<Clip> AddClip(@RequestBody Map<String, String> param) {
		Clip clip = Clip.builder().title(param.get("title")).game_id(param.get("game_id")).url(param.get("url"))
				.build();
		System.out.println(clip);
		clipRepo.save(clip);

		return clipRepo.findAll();
	}

	@GetMapping("/get/games")
	public List<Game> getGameById(@RequestParam(required = false, value = "id") Optional<Long> id,
			@RequestParam(required = false, value = "name") Optional<String> name) {
		List<Game> resultGames = new ArrayList<Game>();
		Optional<Game> resultOp;
		if (id.isPresent()) {
			resultOp = gameRepo.findByIdx(id.get());
			if (resultOp.isPresent())
				resultGames.add(resultOp.get());
		}

		if (name.isPresent()) {
			resultOp = gameRepo.findByName(name);
			resultGames.add(resultOp.get());
		}
		return resultGames;
	}

	@GetMapping("/get/games/all")
	public List<Game> getAllGames() {
		String width = "90";
		String height = "150";
		List<Game> tempList = gameRepo.findAll();
		for (Game g : tempList) {
			g.setBoxArtUrl(g.getBoxArtUrl().replace("{width}", width).replace("{height}", height));
		}
		return tempList;
	}

	@GetMapping("/get/games/top")
	public List<TopGame> getTopGames() {
		String width = "90";
		String height = "150";
		List<TopGame> tempList = topGameRepo.findAll();
		for (TopGame g : tempList) {
			g.setBoxArtUrl(g.getBoxArtUrl().replace("{width}", width).replace("{height}", height));
		}
		return tempList;
	}
}
