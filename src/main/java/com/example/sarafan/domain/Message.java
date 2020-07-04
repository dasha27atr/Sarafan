package com.example.sarafan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id"})
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Id.class)
    private Long id;

    @JsonView(View.IdName.class)
    private String text;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.FullMessage.class)
    private LocalDateTime creationDate;

    @JsonView(View.FullMessage.class)
    private String link;
    @JsonView(View.FullMessage.class)
    private String linkTitle;
    @JsonView(View.FullMessage.class)
    private String linkDescription;
    @JsonView(View.FullMessage.class)
    private String linkCover;
}
