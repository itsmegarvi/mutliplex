package com.example.bookingservice.dto;

import com.example.bookingservice.model.Hall;
import com.example.bookingservice.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowRequestDto {
    private MovieDtoRequest movie;
    private HallDtoRequest hall;
    private Date fromDate;
    private Date toDate;
    private Integer slotNumber;
}