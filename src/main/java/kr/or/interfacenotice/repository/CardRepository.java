package kr.or.interfacenotice.repository;

import kr.or.interfacenotice.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {

}
