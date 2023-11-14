package com.leandro.dslist.entities.game;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

// lomboK getters e setters + equals e hashcode @Data
@Table(name = "tb_game")
@Entity
@Data
@EqualsAndHashCode
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(name = "game-year")
  private Integer year;

  private String genre;
  private String platforms;
  private Double score;
  private String imgUrl;

  @Column(columnDefinition = "TEXT")
  private String shortDescription;

  @Column(columnDefinition = "TEXT")
  private String longDescription;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
