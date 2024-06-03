package com.erp.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.erp.mvc.dto.Person;

@Controller
public class ModelController {
    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * 요청 경로 : /model/person
	 * @param model
	 * @param person
	 * @return
	 */
	@RequestMapping("/model/person")	// method: GET(기본값)
//	public String person(Model model) {
	public String person(Model model, Person person) {
		logger.info("public String person(Model model)");


		// Model 인터페이스의 addAttribute() 메소드로 데이터를 등록하여, 뷰에 전달한다.
		// Model : 컨트롤러에서 등록한 데이터를 뷰에 전달하는 인터페이스
		// Person person = new Person();
		// person.setName("김조은");
		// person.setAge(20);
		
		//addAttribute("변수명", 객체) 메소드로 모델에 객체를 등록한다.
		model.addAttribute("person", person);
		//model.addAttribute(person);				// 변수명을 생략하면 객체명과 일치하는 이름으로 접근할 수 있다.
												// view 에서 ${} (표현언어) 로 사용할 수 있다.
												// ${person.name}, ${person.age}
												// getter 메소드가 정의되어 있어야 위와같이 뷰에서 접근할 수 있다.
		return "model/person";					// view : model/person.jsp
	}
	

	/**
	 * 요청 경로 : /model/person2?name=김조은&age=20
	 * 			* 요청 파라미터의 변수명들을 객체의 필드(멤버변수)로 자동으로 매핑해준다.
	 */
	@RequestMapping("/model/person2")
	//public String person2(Model model, @ModelAttribute Person person) {
    public String person2(@ModelAttribute Person person) {
		logger.info("public String person2(@ModelAttribute Person person) ");

		// @ModelAttribute : 매개변수를 모델에 자동으로 등록해주는 어노테이션
		// http://localhost:8080/model/person2?name=정연철&age=54
		// model.addAttribute("person", person);
		
		return "model/person";				// view : model/person.jsp
	}
	
	/**
	 * 요청 경로 : /model/person
	 * method  : POST
	 *  
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/model/person", method = RequestMethod.POST)
	public String personPost(@RequestParam("name") String personName
						   , @RequestParam("age") int personAge
						   , Model model) {
		logger.info("public String personPost(@RequestParam(name) String personName...");

		// @RequestParam("요청파라미터명") 데이터타입 메소드매개변수명
		// : 요청 매개변수(parameter)를 메소드의 매개변수로 바인딩하는 어노테이션
		// * 요청파라미터명 = 메소드매개변수명 일치하면, 생략가능
		
		Person person = new Person();
		person.setName(personName);
		person.setAge(personAge);
		
		// forward 방식으로 페이지 이동 시, 모델에 데이터 사용가능
		model.addAttribute(person);
		
		return "model/person";				// view : model/person.jsp
	}
	
	
	/**
	 * 요청 경로 : /model/person
	 * method  : POST
	 *  
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/model/person2", method = RequestMethod.POST)
	public String personPost(Model model, Person person, RedirectAttributes rttr) {
		logger.info("public String personPost(Model model, Person person, RedirectAttributes rttr)");

		// RedirectAttributes 인터페이스
		// : 리다이렉트 방식으로 페이지 이동 시, 일회성으로 데이터를 전달하는 인터페이스

		
		// forward 방식으로 페이지 이동 시, 모델에 데이터 사용가능
		// model.addAttribute(person);
		
		// redirect 방식으로 페이지 이동 시, 
		// RedirectAttributes 인터페이스를 통해서 일회성으로 데이터 전달 가능
		rttr.addFlashAttribute("person", person);
		
		// 리다이렉트 : redirect:요청경로
		// * 최초 요청 객체는 사라진다.
		return "redirect:/model/person";				// view : model/person.jsp
	}
	

}