package com.semihbkgr.sequential.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
//This entity is being used by JPA
public class Vocabulary {

    @Id
    private int id;
    private String eng;
    private String tr;

}