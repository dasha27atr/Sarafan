package com.example.sarafan.service;

import com.example.sarafan.domain.Comment;
import com.example.sarafan.domain.User;
import com.example.sarafan.domain.View;
import com.example.sarafan.domain.dto.EventType;
import com.example.sarafan.domain.dto.ObjectType;
import com.example.sarafan.repository.CommentRepository;
import com.example.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepository commentRepository, WsSender wsSender) {
        this.commentRepository = commentRepository;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, View.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepository.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
