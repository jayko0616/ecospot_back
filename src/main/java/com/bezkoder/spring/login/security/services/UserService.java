package com.bezkoder.spring.login.security.services;

import com.bezkoder.spring.login.models.Rank;
import com.bezkoder.spring.login.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bezkoder.spring.login.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final LoadRepository loadRepository;

    @Autowired
    public UserService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    public void updateMessageByUsername(String username, String newMessage) {
        // username으로 사용자 찾기
        Rank user = loadRepository.findByUsername(username);
        if (user != null) {
            // 사용자가 존재하면 message 값을 업데이트
            user.setMessage(newMessage);
            loadRepository.save(user);
        } else {
            // 사용자가 존재하지 않으면 예외 처리 또는 에러 메시지 처리
            throw new IllegalArgumentException("User not found");
        }
    }

    public void updateImageByUsername(String username, String Image) {
        // username으로 사용자 찾기
        Rank user = loadRepository.findByUsername(username);
        if (user != null) {
            // 사용자가 존재하면 message 값을 업데이트
            user.setImage(Image);
            loadRepository.save(user);
        } else {
            // 사용자가 존재하지 않으면 예외 처리 또는 에러 메시지 처리
            throw new IllegalArgumentException("User not found");
        }
    }
}

