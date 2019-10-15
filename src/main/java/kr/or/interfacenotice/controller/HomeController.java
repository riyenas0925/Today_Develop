package kr.or.interfacenotice.controller;

import kr.or.interfacenotice.service.NaverD2Service;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
public class HomeController {

    private final NaverD2Service naverD2Service;

    @Autowired
    public HomeController(NaverD2Service naverD2Service) {
        this.naverD2Service = naverD2Service;
    }

    @RequestMapping("/")
    public String user(){
        log.info("세종대학교 학술동아리 인터페이스 공지사항 접속......");

        naverD2Service.NaverD2Crawl();

        return "home";
    }

}