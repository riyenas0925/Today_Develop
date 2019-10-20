package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.repository.CardRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Inject
    private CardRepository cardRepository;

    @Override
    public List<Card> randomCardList(){

        List<Card> cardList = cardRepository.RandomCardList();

        if(cardList.isEmpty()){
            cardList = null;
        }
        
        return cardList;
    }

    @Override
    public List<Card> findByDevBlog(String devBlog){

        return cardRepository.findByDevBlog(devBlog);
    }
}
