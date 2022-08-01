package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_roll", schema = "dbo", catalog = "DBtest")
public class UserRoll {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "u_id")
    private Long uId;
    @Basic
    @Column(name = "roll_id")
    private Long rollId;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getRollId() {
        return rollId;
    }

    public void setRollId(Long rollId) {
        this.rollId = rollId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoll userRoll = (UserRoll) o;
        return id == userRoll.id && Objects.equals(uId, userRoll.uId) && Objects.equals(rollId, userRoll.rollId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uId, rollId);
    }
}
