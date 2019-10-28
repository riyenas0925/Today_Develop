package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;

import java.util.List;

public interface CardService {
    public List<Card> randomCardList();

    public List<Card> findByDevBlog(String devBlog);
    
    public List<Card> findByUserCard(String userName);
}
