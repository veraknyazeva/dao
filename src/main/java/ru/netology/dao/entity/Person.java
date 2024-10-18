package ru.netology.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persons", schema = "public", catalog = "postgres")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @EmbeddedId
    private PersonsPK personsPK;

    @Basic
    @Column(name = "phone_number")
    private Long phoneNumber;


    @Basic
    @Column(name = "city_of_living")
    private String cityOfLiving;
}
