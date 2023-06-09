package com.diginamic.species.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDTO {

    private int statusCode;

    private LocalDateTime date;

    private String message;

    private String description;

}
