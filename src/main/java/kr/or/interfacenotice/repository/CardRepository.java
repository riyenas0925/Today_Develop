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
    
    String query =  "SELECT c.*,  u.name  FROM user u " +
                    "INNER JOIN usercard uc " +
                    "ON u.userId = uc.userId " +
                    "INNER JOIN card c " + 
                    "ON c.cardId = uc.cardId " +
                    "where u.name = ?1";
    
    @Query(value = query, nativeQuery = true)
    List<Card> findByUserCard(String userName);
}
