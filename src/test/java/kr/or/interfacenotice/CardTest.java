package kr.or.interfacenotice;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.repository.CardRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class CardTest {

    @Inject
    private CardRepository cardRepository;

    @Test
    public void createCard(){
        Card card = new Card();

        card.setCardId(1L);
        card.setCardTitle("test");
        card.setCardCategory("d2");
        card.setCardContent("test");

        cardRepository.save(card);
    }
}