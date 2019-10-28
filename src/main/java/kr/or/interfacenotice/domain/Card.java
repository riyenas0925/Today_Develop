package kr.or.interfacenotice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "card")
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Column(name = "cardUrl", length = 1024)
    private String cardUrl;

    @Column(name = "cardTitle", length = 1024)
    private String cardTitle;

    @Column(name = "cardCategory", length = 1024)
    private String cardCategory;

    @Column(name = "cardContent", length = 1024)
    private String cardContent;

    private String cardColor;

    private LocalDate cardDate;
    
    @OneToMany(mappedBy = "card")
    private List<UserCard> participationList = new ArrayList<>();

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