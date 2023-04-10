package org.itstep.thymeleaf.os;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "os")
public class Os {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "developer")
    private String developer; //Разработчик ОС
}

//Android OS - Google Inc., Windows OS - Microsoft Corporation, iOS - Apple Inc., BlackBerry OS – BlackBerry Ltd.
