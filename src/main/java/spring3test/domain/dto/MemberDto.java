package spring3test.domain.dto;

import lombok.*;
import spring3test.domain.entity.MemberEntity;

@Getter // Get메소드 제공
@Setter // Set메소드 제공
@AllArgsConstructor // 풀 생성자 제공
@NoArgsConstructor // 빈 생성자 제공
@ToString // ToString 메소드 제공
@Builder // 객체 생성시 안정성 보장 builder 메소드 제공
public class MemberDto {

    public  Integer no;
    public  String name;
    public  String phone;
    public  String memo;

    // 설계 관련 api : 룸복 : 생성자 , get,set,빌더,toString() 등 어노테이션 제공

    // 1. dto -> entity 변환 메소드
    public MemberEntity changeEntity(){

            MemberEntity memberEntity = MemberEntity.builder()
                    .name(this.name)
                    .phone(this.phone)
                    .memo(this.memo)
                    .build();
            return memberEntity;

    }


}
