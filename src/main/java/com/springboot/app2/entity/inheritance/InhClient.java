package com.springboot.app2.entity.inheritance;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class InhClient extends InhPerson {

    private String address;

}
