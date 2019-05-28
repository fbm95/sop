package com.sop.sopdal.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "system_user_details")
@Data
public class SystemUserDetails {

    @Id
    @SequenceGenerator(
            name="system_user_details_seq",
            sequenceName="system_user_details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_user_details_seq")
    private int id;

    @Column
    @NotNull(message = "SystemUserDetails cannot be null")
    private String password;

    @Column
    @NotNull(message = "SystemUserDetails cannot be null")
    private String role;
}
