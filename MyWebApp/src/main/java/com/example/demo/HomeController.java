package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // When we use this annotation, this class will start accepting request from web applications.
            // SPECIAL PREFERENCE is given to this class...?
            // Spring boot will make sure that this Controller will be handling all the requests.
            // We have a dispatch servlet behind the scenes which will send the request here.
public class HomeController {
     
	// this is a controller, which decides which page is to open on doing what just like a servlet.
	
	// We need to specify which request is to be handled how. This is done by using the annotaion RequestMapping.
	
//	@RequestMapping("home")
	
//  @ResponseBody -> prints on the page whatever String/text you will return.
//	
//	public String home(HttpServletRequest req) {  // we have a choice to make these objects, unlike in servlets.
//		
//		String name = req.getParameter("name");   // accepting values just like in servlet.
//		
//		System.out.println("Hii, I am controller. and Hii " + name );
//		
//		HttpSession session = req.getSession(); // so we are creating a session and we are setting a new attribute which can
//		                                        // be accessed by all the servlets or jsps.
//		session.setAttribute("name", name);
//		
//		return "home"; //by default spring boot considers this as file name and not data and searches for the 
//		                   //returned item of controller in webapp(path has to be same)
//	}
	// initially, without using tomcat jasper, we get the home file as a downloadbale. This is because spring boot doesn't work
	// work with jsp, doesn't support it.
	
	// we get the same version of Tomcat jasper as our tomcat embedded in our maven dependencies and paste it in pom file.
	// After using tomcat jasper, spring boot supports jsp files.
	
	// <------The above function and stuff is before I used ModelAndView, taking data from client through HttpServlet ------>
	
//	@RequestMapping("home") 
//	public String home(@RequestParam("name") String myname, HttpSession session) { // home(String name, HttpSession session)
//	                                                                               // also works.(Since same name as url)
//		session.setAttribute("name", myname);
// 		return "home";
//	}
	
	// <------------------- Above way uses dependency injection and Request MApping annotation -------------------------->
	
//	@RequestMapping("home")
//	public ModelAndView home(@RequestParam("name") String myName) {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name", myName);  // we can add multiple data too by using this line again and again.
//		mv.setViewName("home");        // this line is important so as to know which View(Page) to show using this function.
//		return mv;
//		
//	}
	
//	<------------------- Above way uses MODELANDVIEW to pass home and accept values. -------------------------->
	
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}
}
