package com.springboot.app2.entity.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class InhBook extends InhProduct {

    private String author;

    public InhBook(String name, String author) {
        super.setName(name);
        this.author = author;
    }

}
