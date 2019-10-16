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
    public List<Card> RandomCardList(){

        List<Card> cardList = new ArrayList<>();

        cardList = cardRepository.RandomCardList();

        return cardList;
    }
}
