package com.springboot.app2.entity.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InhEmployee extends InhPerson {

    private String company;

}
