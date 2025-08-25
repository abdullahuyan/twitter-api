package com.example.twitter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Table(name="user", schema="twitter" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max=100)
    private String username;

    @Column(name="email")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max=100)
    private String email;

    @Column(name="password")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max=100)
    private String password;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Tweet> tweets;

    public void addTweet(Tweet tweet){
        if (tweet.getUser().equals(this)&&!tweets.contains(tweet))
            tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public List<Tweet> getTweets(){
        return Collections.unmodifiableList(this.tweets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
