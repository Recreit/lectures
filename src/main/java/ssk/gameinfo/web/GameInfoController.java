package ssk.gameinfo.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssk.gameinfo.service.GameInfoService;
import ssk.gameinfo.service.GenreService;
import ssk.vo.GameVo;
import ssk.vo.GenreVo;

@Controller("gameInfoController")
public class GameInfoController {
	
	@Resource(name="gameInfoService")
	GameInfoService gameInfoService;
	
	@Resource(name="genreService")
	GenreService genreService;
	
	@RequestMapping("/gameinfo/gameList.do")
	public String gameList (@RequestParam Map<String,String> req, ModelMap model) {
		
		GameVo vo = new GameVo();
		
		List<GameVo> gameList = gameInfoService.gameList(vo);
		model.addAttribute("gameList",gameList);
		
		Map<String,List<GenreVo>> genreList = genreService.genreList(vo);
		model.addAttribute("genreList",genreList);
		
		return "gameinfo/gameList";
	}	
	
	@RequestMapping("/gameinfo/gameDetail.do")
	public String gameDetail (@RequestParam Map<String,String> req, ModelMap model) {
		String game_id = req.get("game_id");
		
		GameVo vo = new GameVo();
		vo.setGame_id(game_id);
		
		Map<String,Object> gameDetail = gameInfoService.gameDetail(vo);
		model.addAttribute("gameDetail",gameDetail);
		
		Map<String,List<GenreVo>> genreList = genreService.genreList(new GameVo());
		model.addAttribute("genreList",genreList);
		
		return "gameinfo/gameDetail";
	}
	
	@RequestMapping("/gameinfo/gameAddView.do")
	public String gameAddView(@RequestParam Map<String,String> req, ModelMap model) {
		
		List<GameVo> list = gameInfoService.gameList(new GameVo());
		model.addAttribute("gameList",list);
		
		return "gameinfo/gameAdd";
	}
	
	@RequestMapping("/gameinfo/gameAdd.do")
	public String gameAdd(@RequestParam Map<String,String> req, ModelMap model) {	
	
		String rtnUrl = "redirect:/gameinfo/gameList.do";
		
		GameVo vo = new GameVo();
		vo.setGame_id(req.get("game_id"));
		vo.setTitle_ko(req.get("title_ko"));
		vo.setTitle_en(req.get("title_en"));
		vo.setDesigner(req.get("designer"));
		vo.setMake_year(req.get("make_year"));
		vo.setPlay_min(req.get("play_min"));
		vo.setPlay_max(req.get("play_max"));
		
		int resultCnt = gameInfoService.gameAdd(vo);
		
		if (resultCnt < 1) {
			rtnUrl = "redirect:/gameinfo/gameAddView.do";
		}
		
		return rtnUrl;
	}
}
