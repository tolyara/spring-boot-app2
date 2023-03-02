package com.springboot.app2.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pets")
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


