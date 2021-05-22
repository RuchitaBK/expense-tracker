package com.expensetrackersvc.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expense")
public class Expense {
    @Id
    private Long expenseId;
    private String descript;
    private int expenseAmount;
    private Instant expenseDate;

    @ManyToOne
    private Category category;

    @JsonIgnore
    @ManyToOne
    private User user;


}
