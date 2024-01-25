package com.example.assetapi.dto;


import com.example.assetapi.enums.Interval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCriteria {

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Interval interval;
}
