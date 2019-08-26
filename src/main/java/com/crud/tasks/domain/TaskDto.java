package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@NotNull
@NoArgsConstructor
public class TaskDto {
    private long id;
    private String title;
    private String content;
}
