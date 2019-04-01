package com.example.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
@Entity //表
public class IdCard {

    @Id(autoincrement = true)
    private Long id;//学院ID
    @Index(unique = true)
    private Long shengFengCardId;
    @Generated(hash = 1289194010)
    public IdCard(Long id, Long shengFengCardId) {
        this.id = id;
        this.shengFengCardId = shengFengCardId;
    }
    @Generated(hash = 1500073048)
    public IdCard() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getShengFengCardId() {
        return this.shengFengCardId;
    }
    public void setShengFengCardId(Long shengFengCardId) {
        this.shengFengCardId = shengFengCardId;
    }

}
