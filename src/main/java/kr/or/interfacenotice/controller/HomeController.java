package kr.or.interfacenotice.controller;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.service.CardService;
import kr.or.interfacenotice.service.NaverD2Service;
import kr.or.interfacenotice.service.WooWaBrosService;
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

    private final CardService cardService;
    private final NaverD2Service naverD2Service;
    private final WooWaBrosService wooWaBrosService;

    @Autowired
    public HomeController(CardService cardService,
                          NaverD2Service naverD2Service,
                          WooWaBrosService wooWaBrosService) {
        this.cardService =cardService;
        this.naverD2Service = naverD2Service;
        this.wooWaBrosService = wooWaBrosService;
    }

    @RequestMapping("/")
    public String user(Model model){
        log.info("세종대학교 학술동아리 인터페이스 공지사항 접속......");

        List<Card> cardList= cardService.RandomCardList();

        model.addAttribute("cardList", cardList);

        return "home";
    }

    @GetMapping("/init")
    public String init(){
        log.info("전체 게시물 크롤링 중 ......");

        naverD2Service.NaverD2Crawl();
        wooWaBrosService.WooWaBrosCrawl();

        return "redirect:/";
    }
}