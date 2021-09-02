package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//RestController (데이터를 리턴한다)
//Controller(파일을 리턴한다)
@Controller
public class FrontController {
	
	//http:localhost:8080/home
	//디스패쳐 서블릿 /home 파싱
	//IOC 컨테이너에 안에서 @RestController과 @Controller로 뛰어진 객체를 찾는다
	// 메서도 /home을 호출한다.
	
	@GetMapping("/home")
	public String home(Model model) {//request == model
		//ViewResolver
		//scr/main/resources/templates(prefix)
		//.mustache(suffix)
		
		String name ="조재영";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목2"));
		
		
		model.addAttribute("boards", boards);
		return "home"; //RequestDispatcher가 자동작동
	}
}
