package kr.or.interfacenotice.repository;

import kr.or.interfacenotice.domain.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {

    @Query(value = "SELECT * FROM CARD ORDER BY rand() LIMIT 9", nativeQuery = true)
    List<Card> RandomCardList();

    @Query(value = "SELECT * FROM CARD WHERE CARDCATEGORY= ?1", nativeQuery = true)
    List<Card> findByDevBlog(String devBlog);
}
