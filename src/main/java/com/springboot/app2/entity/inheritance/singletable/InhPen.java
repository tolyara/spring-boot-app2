package com.springboot.app2.entity.inheritance.singletable;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class InhPen extends InhProduct {

    private String color;

}
