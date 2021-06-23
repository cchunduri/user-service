package com.chaitu.entities;

import com.chaitu.dto.AppUserDto;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "phone_number_ext")
    private Integer phoneNumberExt;

    public static AppUser mapper(AppUserDto appUserDto) {
        return AppUser.builder()
                .firstName(appUserDto.firstName())
                .lastName(appUserDto.lastName())
                .email(appUserDto.email())
                .password(appUserDto.password())
                .phoneNumber(appUserDto.phoneNumber())
                .phoneNumberExt(appUserDto.phoneNumberExt())
                .build();
    }
}
