package com.codecentric.findtalent.domain;

import jakarta.persistence.*;
import org.kohsuke.github.GHUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String name;

    private String location;

    private String email;

    private String bio;

    private String createdAt;

    private String avatarUrl;

    @OneToMany(mappedBy = "member")
    private List<Repo> repository;

    public Member(GHUser ghUser) {
        this.id = ghUser.getId();
        this.username = ghUser.getLogin();
        try {
            this.name = ghUser.getName();
            this.location = ghUser.getLocation();
            this.email = ghUser.getEmail();
            this.bio = ghUser.getBio();
            this.createdAt = ghUser.getCreatedAt().toString();
            if (ghUser.getName() == null) {
                this.name = "This user has not provided a name";
            }
            if (ghUser.getLocation() == null) {
                this.location = "Sorry, we don't know the location.";
            }
            if (ghUser.getEmail() == null) {
                this.email = "Sorry, we don't know the email.";
            }
            if (ghUser.getBio() == null) {
                this.bio = "This user has not provided a bio";
            }
            if (ghUser.getCreatedAt() == null) {
                this.createdAt = "Sorry, we don't know the date of creation.";
            }
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Could not find file");
        }
        this.avatarUrl = ghUser.getAvatarUrl();
        this.repository = new ArrayList<>();
    }

    public Member() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member member)) return false;
        return Objects.equals(getId(), member.getId()) && Objects.equals(getUsername(), member.getUsername()) && Objects.equals(getName(), member.getName()) && Objects.equals(getLocation(), member.getLocation()) && Objects.equals(getEmail(), member.getEmail()) && Objects.equals(getBio(), member.getBio()) && Objects.equals(getCreatedAt(), member.getCreatedAt()) && Objects.equals(getAvatarUrl(), member.getAvatarUrl()) && Objects.equals(getRepository(), member.getRepository());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getName(), getLocation(), getEmail(), getBio(), getCreatedAt(), getAvatarUrl(), getRepository());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<Repo> getRepository() {
        return repository;
    }

    public void setRepository(List<Repo> repository) {
        this.repository = repository;
    }
}
