package com.obinna.FashionBlog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
    @CreationTimestamp
    private LocalDate creationDate;
    @UpdateTimestamp
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "post_model_id", referencedColumnName = "id")
    @JsonBackReference
    private PostModel postModel;

    @ManyToOne
    @JoinColumn(name = "user_model_id", referencedColumnName = "id")
    @JsonBackReference
    private UserModel userModel;

    @OneToMany(mappedBy = "comment")
    @JsonManagedReference
    private List<Like> likes = new ArrayList<>();

}
