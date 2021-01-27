package Hometask11.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
@Data
public class Score {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "score")
    private int score;
}
