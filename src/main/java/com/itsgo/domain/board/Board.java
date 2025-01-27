package com.itsgo.domain.board;

import com.itsgo.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "board_basic")
public abstract class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    private String boardTitle;

    @Column(columnDefinition = "MEDIUMINT UNSIGNED") // UNSIGNED
    private Integer boardHit;

    @Lob
    private String boardContent;

    @Column(columnDefinition = "TINYINT UNSIGNED")
    private Integer boardLike;

    @CreatedBy
    private String createdBy;

    public Board(String boardTitle, String boardContent) {
        super();
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }
}

