package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.repository.CardRepository;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class LezhinServiceImpl implements LezhinService {

    @Inject
    private CardRepository cardRepository;

    @Override
    public List<Card> LezhinCrawl() {
        List<Card> cardList = new ArrayList<>();

        LezhinCrawlPage(1, cardList);
        LezhinCrawlPage(2, cardList);
        LezhinCrawlPage(3, cardList);
        LezhinCrawlPage(4, cardList);

        cardRepository.saveAll(cardList);

        return cardList;
    }

    private void LezhinCrawlPage(Integer page, List<Card> cardList) {

        String url = null;
        Document doc = null;

        if(page == 1){
            url = "https://tech.lezhin.com";
        } else {
            url = "https://tech.lezhin.com/pages/" + page;
        }

        try {
            doc = Jsoup.connect(url)
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .get();
        } catch (IOException e){
            e.printStackTrace();
        }

        Elements contenList = doc.select(".post-item");

        for (int i = 0; i < contenList.size(); i++){
            Card card = new Card();
            Element content = contenList.get(i);

            String postUrl = content.select("a").attr("href");
            String postTitle = content.select(".post-title").text();
            String postHtml = content.select(".post-summary").text();
            String postDate = content.select(".post-date").text();
            String postCategory = "레진코믹스";
            String cardColor = "border-info";

            card.setCardTitle(postTitle);
            card.setCardContent(postHtml);
            card.setCardCategory(postCategory);
            card.setCardUrl(postUrl);
            card.setCardColor(cardColor);
            card.setCardDate(LocalDate.parse(postDate));

            cardList.add(card);
        }
    }


    public List<Card> LezhinList(){
        return cardRepository.findByDevBlog("레진코믹스");
    }
}