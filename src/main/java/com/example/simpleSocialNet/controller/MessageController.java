package com.example.simpleSocialNet.controller;

import com.example.simpleSocialNet.domain.Message;
import com.example.simpleSocialNet.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;
    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    // Домашняя страница
    @GetMapping
    public List<Message> list() {
        return messageRepo.findAll();
    }

    //
    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    // создание нового
    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    // обновление по id
    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb,"id");

        return messageRepo.save(messageFromDb);
    }

    // удаление по id
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}
