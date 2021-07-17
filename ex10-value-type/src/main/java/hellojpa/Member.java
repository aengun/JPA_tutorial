package hellojpa;

import com.sun.xml.internal.rngom.parse.host.Base;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    // 기간
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
    @Embedded
    private Period workPeriod;

    // 주소
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address homeAddress;

    // Address 중복 사용하는 경우
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "city",
//                    column = @Column(name = "work_city")),
//            @AttributeOverride(name = "street",
//                    column = @Column(name = "work_street")),
//            @AttributeOverride(name = "zipcode",
//                    column = @Column(name = "work_zipcode"))
//    })
//    private Address workAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
