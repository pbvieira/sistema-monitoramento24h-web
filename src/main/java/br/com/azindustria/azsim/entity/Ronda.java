package br.com.azindustria.azsim.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ronda_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ronda_seq")
    @SequenceGenerator(name = "ronda_seq", sequenceName = "ronda_seq")
    private Long id;

    @Column(length = 4000)
    private String procedimento;

}
