package com.obinna.FashionBlog.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {

    private String title;
    private String description;
}
