package com.springboot.app2.entity.inheritance;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public class InhPerson {

    @Id
    private Long id;
    private String name;

}
