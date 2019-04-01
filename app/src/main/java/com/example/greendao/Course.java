package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity //表
public class Course {
    @Id(autoincrement = true)
    private Long Id;//ID

    private String name;

    private Long courseId;//ID

    @Generated(hash = 564078147)
    public Course(Long Id, String name, Long courseId) {
        this.Id = Id;
        this.name = name;
        this.courseId = courseId;
    }

    @Generated(hash = 1355838961)
    public Course() {
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

}
