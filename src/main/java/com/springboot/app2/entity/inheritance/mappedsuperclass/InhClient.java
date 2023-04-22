package com.springboot.app2.entity.inheritance.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class InhClient extends InhPerson {

    private String address;

    public InhClient(Long id, String name, String address) {
        super(id, name);
        this.address = address;
    }

}
