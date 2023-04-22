package com.springboot.app2.entity.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class InhEmployee extends InhPerson {

    private String company;

}
