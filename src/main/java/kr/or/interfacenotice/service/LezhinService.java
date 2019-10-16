package kr.or.interfacenotice.service;

import kr.or.interfacenotice.domain.Card;

import java.util.List;

public interface LezhinService {
    public List<Card> LezhinCrawl();

    public List<Card> LezhinList();
}
