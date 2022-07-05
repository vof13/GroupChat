package com.example.groupchat;

import com.example.groupchat.model.User;
import com.example.groupchat.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class GroupChatController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/init")
    public HashMap <String, Boolean> init () {
        HashMap <String, Boolean> response = new HashMap<>();
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        Optional<User> userOptional = userRepository.findBySessionId(sessionId);
        response.put("result", userOptional.isPresent());
        return response;
    }

    @PostMapping("/message")
    public Boolean sendMessage(@RequestParam String message) {
        return true;
    }

    @PostMapping("/auth")
    public HashMap <String, Boolean> auth(@RequestParam String name) {
        HashMap <String, Boolean> response = new HashMap<>();
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        User user = new User();
        user.setName(name);
        user.setSessionId(sessionId);
        userRepository.save(user);
        response.put("result", true);
        return response;
    }

    @GetMapping("/message")
    public List<String> getMessagesList(){
        return null;
    }

    @GetMapping("/user")
    public HashMap<Integer, String> getUsersList() {
        return null;
    }


}
