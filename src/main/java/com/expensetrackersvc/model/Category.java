package com.expensetrackersvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    private Long categoryId;
    private String categoryName;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private User user;
}
