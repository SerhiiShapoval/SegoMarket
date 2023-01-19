package com.example.segomarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String originalFileName;
    private Long size;
    private String contentType;
    private boolean isPreviewImage;
   @Lob
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
     private Product product;
    private LocalDateTime dateTimeOfCreated;

    @PrePersist
    private void init(){
        dateTimeOfCreated = LocalDateTime.now();
    }
}
