package com.alex.springv2.domain.entity;

import com.alex.springv2.domain.TestStatus;
import lombok.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentSuccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int questNumber;
    private int writeAnswer;
    private int wrongAnswer;

    @Enumerated(EnumType.STRING)
    private TestStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "test_id" ,nullable = false)
    private Test test;

}
