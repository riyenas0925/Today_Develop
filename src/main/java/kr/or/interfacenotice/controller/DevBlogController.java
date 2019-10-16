package kr.or.interfacenotice.controller;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.service.CardService;
import kr.or.interfacenotice.service.LezhinService;
import kr.or.interfacenotice.service.NaverD2Service;
import kr.or.interfacenotice.service.WooWaBrosService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log
@Controller
public class DevBlogController {

    private final NaverD2Service naverD2Service;
    private final WooWaBrosService wooWaBrosService;
    private final LezhinService lezhinService;

    @Autowired
    public DevBlogController(NaverD2Service naverD2Service,
                             WooWaBrosService wooWaBrosService,
                             LezhinService lezhinService) {


        this.naverD2Service = naverD2Service;
        this.wooWaBrosService = wooWaBrosService;
        this.lezhinService = lezhinService;
    }

    @GetMapping("devBlog/init")
    public String init(){
        log.info("Naver D2 게시글 파싱중......");
        naverD2Service.NaverD2Crawl();

        log.info("우아한 형제들 게시글 파싱중......");
        wooWaBrosService.WooWaBrosCrawl();

        log.info("레진 코믹스 게시글 파싱중......");
        lezhinService.LezhinCrawl();

        return "redirect:/";
    }

    @GetMapping("devBlog/NaverD2")
    public String NaverD2(Model model){
        log.info("NaverD2 게시글 불러오는중 ......");

        List<Card> cardList= naverD2Service.NaverD2List();

        model.addAttribute("cardList", cardList);

        return "naver";
    }

    @GetMapping("devBlog/WooWaBros")
    public String WooWaBros(Model model){
        log.info("우아한 형제들 게시글 불러오는중 ......");

        List<Card> cardList= wooWaBrosService.WooWaBrosList();

        model.addAttribute("cardList", cardList);

        return "woowa";
    }

    @GetMapping("devBlog/Lezhin")
    public String Lezhin(Model model){
        log.info("레진코믹스 게시글 불러오는중 ......");

        List<Card> cardList= lezhinService.LezhinList();

        model.addAttribute("cardList", cardList);

        return "lezhin";
    }
}
