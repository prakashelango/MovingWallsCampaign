package com.base.movingwalls.model.campaign;

import com.base.movingwalls.common.core.Builder;
import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Indexed
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Field(termVector = TermVector.YES)
    private String name;

    @Field(termVector = TermVector.YES)
    private String duration;

    @Field(termVector = TermVector.YES)
    private String status;

    @Field(termVector = TermVector.YES)
    private LocalDateTime startDate;

    @Field(termVector = TermVector.YES)
    private LocalDateTime endDate;

    @Field
    private String report;

    public Campaign() {
    }

    public Campaign(String name, String duration, String status, LocalDateTime startDate, LocalDateTime endDate, String report) {
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.report = report;
    }

    public static Builder<Campaign> builder() {
        return Builder.of(Campaign.class);
    }
}
