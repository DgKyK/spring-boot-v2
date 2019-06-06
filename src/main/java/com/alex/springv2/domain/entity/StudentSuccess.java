package com.alex.springv2.domain.entity;

import com.alex.springv2.domain.TestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentSuccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String testName;
    private String testTheme;
    private int questNumber;
    private int writeAnswer;
    private int wrongAnswer;

    @Enumerated(EnumType.STRING)
    private TestStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestTheme() {
        return testTheme;
    }

    public void setTestTheme(String testTheme) {
        this.testTheme = testTheme;
    }

    public int getQuestNumber() {
        return questNumber;
    }

    public void setQuestNumber(int questNumber) {
        this.questNumber = questNumber;
    }

    public int getWriteAnswer() {
        return writeAnswer;
    }

    public void setWriteAnswer(int writeAnswer) {
        this.writeAnswer = writeAnswer;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public TestStatus getStatus() {
        return status;
    }

    public void setStatus(TestStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
