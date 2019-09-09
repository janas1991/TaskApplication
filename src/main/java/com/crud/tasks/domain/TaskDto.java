package com.crud.tasks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
@NotNull
@NoArgsConstructor
@ToString
public class TaskDto {
    private long id;
    private String title;
    private String content;
}
