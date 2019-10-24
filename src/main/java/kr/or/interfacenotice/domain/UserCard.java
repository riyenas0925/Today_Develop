package kr.or.interfacenotice.domain;

import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;

@Entity
@IdClass(UserCard.class)
public class UserCard implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;
}