package herogate.ggwp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import herogate.ggwp.api.TwitchApiService;
import herogate.ggwp.dao.TestDao;

@Controller
public class MainController {

	@Autowired
	TestDao testdao;

	@Autowired
	TwitchApiService twitchApiService;

	@GetMapping("/")
	public String maintest(Model model) {
//		model.addAttribute("clipList",twitchApiService.getTwitchClipsList());
		return "main";
	}

	@GetMapping("/clipView")
	public String clipView() {
		return "clipView.html";
	}

	@GetMapping("/login/twitch")
	public String twitchLogin() {
		String url = "https://id.twitch.tv/oauth2/authorize?";

		String client_id = "rnk9pimdln8x5b3tq73dxr79c31a8o";
		String response_type = "token";
		String redirect_uri = "http://localhost:8080/login/process"; // 로그인 인증의 결과를 전달받을 callback url
		String state = ""; // 고유 세션을 나타내는 값
		String force_verify = "false";
		// CSRF 방지를 위한 state token 생성
		state = RandomStringUtils.randomAlphabetic(10);
		String scope = "user:edit+user:read:email";

		// state token 쿠키 저장
		// Cookie c = new Cookie("paycoStateCd", state);
		// c.setMaxAge(2000);
		// response.addCookie(c);
		// URL 생성
		url = url + "client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&response_type=" + response_type
				+ "&state=" + state + "&force_verify=" + force_verify + "&scope=" + scope;

		return "redirect:" + url;
	}

	@GetMapping("/login/process")
	@ResponseBody
	public String getOAuth2TwitchToken(HttpServletRequest request,
			@RequestHeader @RequestParam Map<String, Object> paramMap) {
		System.out.println(request.getRequestURI());
		System.out.println(paramMap.toString());

		return paramMap.toString();
	}
}
