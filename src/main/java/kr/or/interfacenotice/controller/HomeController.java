package kr.or.interfacenotice.controller;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.service.NaverD2Service;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Log
@Controller
public class HomeController {

    private final NaverD2Service naverD2Service;

    @Autowired
    public HomeController(NaverD2Service naverD2Service) {
        this.naverD2Service = naverD2Service;
    }

    @RequestMapping("/")
    public String user(Model model){
        log.info("세종대학교 학술동아리 인터페이스 공지사항 접속......");

        List<Card> cardList= naverD2Service.NaverD2CardList();

        log.info(cardList.toString());

        model.addAttribute("cardList", cardList);

        return "home";
    }

    @GetMapping("/init")
    public void init(){
        log.info("NAVER D2 게시물 크롤링 중 ......");

        naverD2Service.NaverD2Crawl();
    }
}