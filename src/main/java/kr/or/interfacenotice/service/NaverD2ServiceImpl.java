package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.repository.CardRepository;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log
@Service
public class NaverD2ServiceImpl implements NaverD2Service {

    @Inject
    private CardRepository cardRepository;

    @Override
    public List<Card> NaverD2Crawl(){

        String url = "https://d2.naver.com/api/v1/contents?categoryId=2&page=0&size=1000";
        Document doc = null;

        try {
            doc = Jsoup.connect(url)
                    .header("content-type", "application/json;charset=UTF-8")
                    .ignoreContentType(true)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject = (JSONObject) jsonParser.parse(doc.text());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray contentList = (JSONArray) jsonObject.get("content");

        List<Card> cardList = new ArrayList<>();

        for (int i = 0; i < contentList.size(); i++){
            Card card = new Card();
            JSONObject content = (JSONObject) contentList.get(i);

            String postUrl = (String)content.get("url");
            String postTitle = (String)content.get("postTitle");
            String postHtml = (String)content.get("postHtml");
            String postCategory = "NAVER D2";
            String cardColor = "border-success";
            String cardDate = getPostDate((Long)content.get("postPublishedAt"));

            card.setCardTitle(postTitle);
            card.setCardContent(postHtml);
            card.setCardCategory(postCategory);
            card.setCardUrl("https://d2.naver.com" + postUrl);
            card.setCardColor(cardColor);
            card.setCardDate(LocalDate.parse(cardDate));

            cardList.add(card);
        }

        cardRepository.saveAll(cardList);

        return cardList;
    }

    private String getPostDate(long time) {
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd");
        String cardDate = dayTime.format(new Date(time));

        return cardDate;
    }

    @Override
    public List<Card> NaverD2List(){
        return cardRepository.findByDevBlog("NAVER D2");
    }
}
