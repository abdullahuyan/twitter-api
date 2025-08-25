package com.example.twitter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Table(name="tweet", schema="twitter" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content")
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 300)
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private List<Retweet> retweets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(id, tweet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
