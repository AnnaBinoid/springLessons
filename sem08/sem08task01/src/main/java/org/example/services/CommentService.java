package org.example.services;

import org.example.aspects.ToLog;
import org.example.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment){
        System.out.println("Publishing comment : "
                + comment.getText());
        return "SUCCESS";

    }

//    public void method1(){
//        System.out.println("Publishing comment : Method1 was called");
//    }

    public void setLogger(Logger logger){
        this.logger = logger;
    }
}
