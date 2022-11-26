package com.example.simpleSocialNet.repo;

import com.example.simpleSocialNet.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
