package com.example.sarafan.domain.dto;

import com.example.sarafan.domain.Message;
import com.example.sarafan.domain.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonView(View.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}
