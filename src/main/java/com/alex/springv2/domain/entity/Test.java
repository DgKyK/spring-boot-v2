package com.alex.springv2.domain.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Test {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    private String name;
    private String theme;
    private int questNumber;
    private int needAnswerNumb;
/*

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Transient
    private List<StudentSuccess> studentSuccesses;
*/

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getQuestNumber() {
        return questNumber;
    }

    public void setQuestNumber(int questNumber) {
        this.questNumber = questNumber;
    }

    public int getNeedAnswerNumb() {
        return needAnswerNumb;
    }

    public void setNeedAnswerNumb(int needAnswerNumb) {
        this.needAnswerNumb = needAnswerNumb;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theme='" + theme + '\'' +
                ", questNumber=" + questNumber +
                ", needAnswerNumb=" + needAnswerNumb +
                '}';
    }
}
