package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;

import java.util.List;

public interface WooWaBrosService {
    public List<Card> WooWaBrosCrawl();

    public List<Card> WooWaBrosList();
}
