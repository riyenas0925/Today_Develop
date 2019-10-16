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
import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
public class WooWaBrosServiceImpl implements WooWaBrosService {

    @Inject
    private CardRepository cardRepository;

    @Override
    public List<Card> WooWaBrosCrawl() {
        String url = "http://woowabros.github.io/";
        Document doc = null;
        Document iframeContentDoc = null;

        try {
            doc = Jsoup.connect(url)
                    .timeout(3000)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .get();
        } catch (IOException e){
            e.printStackTrace();
        }

        List<Card> cardList = new ArrayList<>();
        Elements contenList = doc.select(".list-module");

        for (int i = 0; i < contenList.size(); i++){
            Card card = new Card();
            Element content = contenList.get(i);

            String postUrl = content.select("a").attr("href");
            String postTitle = content.select(".post-link").text();
            String postHtml = content.select(".post-description").text();
            String postCategory = "우아한 형제들";
            String cardColor = "border-danger";

            card.setCardTitle(postTitle);
            card.setCardContent(postHtml);
            card.setCardCategory(postCategory);
            card.setCardUrl("http://woowabros.github.io" + postUrl);
            card.setCardColor(cardColor);
            cardList.add(card);
        }

        cardRepository.saveAll(cardList);

        return new ArrayList<>();
    }

    @Override
    public List<Card> WooWaBrosList(){
        return cardRepository.findByDevBlog("우아한 형제들");
    }
}
