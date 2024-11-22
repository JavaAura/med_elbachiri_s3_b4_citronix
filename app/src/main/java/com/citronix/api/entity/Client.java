package com.citronix.api.entity;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name required")
    private String name;

    @NotNull(message = "phone required")
    private String phone;

    @NotNull(message = "email required")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales;
}
