package com.example.twitter.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Table(name="like", schema="twitter" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tweet_id")
    private Tweet tweet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(id, like.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
