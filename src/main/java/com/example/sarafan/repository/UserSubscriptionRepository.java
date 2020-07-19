package com.example.sarafan.repository;

import com.example.sarafan.domain.User;
import com.example.sarafan.domain.UserSubscription;
import com.example.sarafan.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
}
