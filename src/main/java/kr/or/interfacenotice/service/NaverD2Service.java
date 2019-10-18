package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;

import java.util.List;

public interface NaverD2Service {
    public List<Card> NaverD2Crawl();

    public List<Card> NaverD2List();
}
