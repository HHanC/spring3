package spring3test.domain.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity // 일반 클래스
public class MemberEntity {

    @Id // pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto키
    public Integer no;

    @Column
    public String name;

    @Column
    public String phone;

    @Column
    public String memo;

}
