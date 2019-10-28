package kr.or.interfacenotice.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.or.interfacenotice.domain.Card;
import kr.or.interfacenotice.service.CardService;

@RestController
public class DevBlogRestController {
    
    @Inject
    private CardService cardService;
    
    @GetMapping("/devBlog/random")
    public ResponseEntity<List<Card>> randomDevBlog(){

        ResponseEntity<List<Card>> entity = null;

        try {
            entity = new ResponseEntity<>(cardService.randomCardList(), HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
    
    @GetMapping("/devBlog/{userName}")
    public ResponseEntity<List<Card>> UserCard(@PathVariable String userName){

        ResponseEntity<List<Card>> entity = null;

        try {
            entity = new ResponseEntity<>(cardService.findByUserCard(userName), HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}