package kr.or.interfacenotice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "card")
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;

    @Column(name = "cardUrl", length = 1024)
    private String cardUrl;

    @Column(name = "cardTitle", length = 1024)
    private String cardTitle;

    @Column(name = "carCategory", length = 1024)
    private String cardCategory;

    @Column(name = "cardContent", length = 1024)
    private String cardContent;

    private String cardColor;

    public void Card(String cardUrl, String cardTitle, String cardCategory, String cardContent) {
        this.cardUrl = cardUrl;
        this.cardTitle = cardTitle;
        this.cardCategory = cardCategory;
        this.cardContent = cardContent;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardUrl='" + cardUrl + '\'' +
                ", cardTitle='" + cardTitle + '\'' +
                ", cardCategory='" + cardCategory + '\'' +
                ", cardContent='" + cardContent + '\'' +
                '}';
    }
}