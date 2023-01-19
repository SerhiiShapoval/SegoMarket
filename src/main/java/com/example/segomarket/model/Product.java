package com.example.segomarket.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private int price;
    private String author;
    private String city;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image>images = new ArrayList<>();

    private Long previewImageId;
    public void addImageToProduct(Image image){
     image.setProduct(this);
     images.add(image);
    }
}
