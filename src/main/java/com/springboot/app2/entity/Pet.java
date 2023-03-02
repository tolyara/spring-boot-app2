package com.springboot.app2.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "pets")
@NamedQuery(name = "Pet.byNick", query = "from Pet where nick = ?1")
@NamedNativeQuery(name = "Pet.byStudent", query = "select * from pets where student_id = ?1", resultClass = Pet.class)
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nick;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Pet() {
    }

    public Pet(Long id, Student student) {
        this.id = id;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", studentId=" + student.getId() +
                '}';
    }

}


