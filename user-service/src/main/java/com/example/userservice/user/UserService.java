package com.example.userservice.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final IUserRepository userRepository;

    public void createUser(UserRequest userRequest) {
        UserModel user = UserModel.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .createdAt(userRequest.getCreatedAt())
                .deletedAt(userRequest.getDeletedAt())
                .build();

        userRepository.save(user);
        log.info("User {} is created", user.getId());
    }

    public List<UserResponse> getAllUser() {
        List<UserModel> user = userRepository.findAll();
        return user.stream().map(this::mapToUserResponse).toList();
    }

    private UserResponse mapToUserResponse(UserModel userModel) {
        return UserResponse.builder()
                .id(userModel.getId())
                .username(userModel.getUsername())
                .password(userModel.getPassword())
                .createdAt(userModel.getCreatedAt())
                .deletedAt(userModel.getDeletedAt())
                .build();
    }

    public UserModel getUser(@PathVariable long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    public UserModel updateUser(UserModel user, long id) {
        UserModel existingUser = userRepository.findById(id).orElseThrow();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setCreatedAt(user.getCreatedAt());
        existingUser.setDeletedAt(user.getDeletedAt());
        userRepository.save(existingUser);
        return existingUser;
    }
}
