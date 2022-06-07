package spring3test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring3test.domain.dto.MemberDto;
import spring3test.domain.entity.MemberRepository;
import spring3test.domain.entity.MemberEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class Indexservice { // 자바 로직 싱행되는 클래스

    @Autowired // 자동 빈생성
    MemberRepository memberRepository;

    // 1. 생성
    public  boolean  create(MemberDto memberDto){
        System.out.println("저장 서비스 호출");
        // 1. Dto -> entity 변환
        MemberEntity memberEntity = memberDto.changeEntity();
        // 2. entity save
        int no = memberRepository.save(memberEntity).getNo(); // 저장 후에 기본키 빼오기
        // 3. 반환
        System.out.println("저장된 엔티티 번호 : " + no);

        if(no > 1){return  true;}
        else{return  false;}
    }
    // 2. 호출
    public  List<MemberDto>  read(){
        System.out.println("호출 서비스 호출");

        List<MemberEntity> entitys = memberRepository.findAll(); // 아무 조건 없는 모든 엔티티 호출
        // entity -> dto 변환
        List<MemberDto> dtos = new ArrayList<>();
        for(MemberEntity entity : entitys){ // 반복문
            dtos.add(MemberDto.builder()
                    .no(entity.getNo())
                    .name(entity.getName())
                    .phone(entity.getPhone())
                    .memo(entity.getMemo())
                    .build());
        }
        return dtos;
    }
    // 3. 수정
    public  void  update(){
        System.out.println("수정 서비스 호출");
    }
    // 4. 삭제
    public  void  delete(){
        System.out.println("삭제 서비스 호출");
    }

}
