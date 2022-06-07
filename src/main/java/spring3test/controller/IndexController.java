package spring3test.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring3test.domain.dto.MemberDto;
import spring3test.service.Indexservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    // RESTFUL 정의
        // 1. 자원(URL) 2. 행위(HTTP Method) 3. 표현
        // 2. 행위(HTTP Method)
            //                          CRUD        차이[멱동성 = 기록 O/X]
            // 1. @PostMapping          C           X           회원가입/로그인(등록)
            // 2.  @GetMapping          R           O
            // 2.  @PutMapping          U           O
            // 2.  @DeleteMapping       D           O

            // * 여러번 호출 했을때 POST는 호출 할때마다 데이터 새로 생성
            // * AJAX ------------> SPRING CONTROLLER
            // * AJAX METHOD : POST -------------->  @PostMapping
            // * AJAX METHOD : GET -------------->  @GetMapping
            // * AJAX METHOD : PUT -------------->  @PutMapping
            // * AJAX METHOD : DELETE -------------->  @DeleteMapping
    @GetMapping("/")
    public String index() {return "main";}

    //static Indexservice indexservice = new Indexservice();
    @Autowired // 자동 빈 생성 = 빈 생성자 이용한 메모리 할당 // new 사용하지 않아도 메모리 할당
    Indexservice indexservice; // new 사용하지 않아도 메모리 할당

    @PostMapping("/create")
    @ResponseBody
    public boolean create(@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("memo") String memo){
//        // DTO  풀 생성자 사용
//        MemberDto memberDto = new MemberDto(0,name,phone,memo);
//        // DTO 빈 생성자 사용
//        MemberDto memberDto2 = new MemberDto();
//        memberDto2.setNo(0);
//        memberDto2.setName(name);
//        memberDto2.setPhone(phone);
//        memberDto2.setMemo(memo);
        // 3. builder 사용시   객체명 = Dto명.vullder().필드명1(값1).build();
        MemberDto memberDto3 = MemberDto.builder()
        .phone(phone)
        .name(name)
        .memo(memo)
        .build();
        // 생성자 vs 빌더 차이점  [빌더 : 안정성보장]
            // 1. 생성자 인수 순서를 무조건 지켜야 한다.!
            // 2. 생성자 인수 개수를 무조건 마춘다.!
        System.out.println("Dto 확인 : " + memberDto3.toString());
        boolean result = indexservice.create(memberDto3); // new 를 사용하지 않아도 메소드 호출 가능

        return result;

    }

    @GetMapping("/read")
    public void read(HttpServletResponse response){
        System.out.println("asdasd");
        List<MemberDto> dtos = indexservice.read();
        JSONArray jsonArray = new JSONArray();
        // json형변환
        for(MemberDto dto : dtos) {
            JSONObject object = new JSONObject();
            object.put("no", dto.getNo());
            object.put("name", dto.getName());
            object.put("phone", dto.getPhone());
            object.put("memo", dto.getMemo());

            jsonArray.put(object);
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
           response.getWriter().print(jsonArray);
        }catch (Exception e) {System.out.println(e);}
    }

    @PutMapping("/update")
    @ResponseBody
    public String update(){

        indexservice.update(); // new 를 사용하지 않아도 메소드 호출 가능

        return "수정 성공";
    }

    @DeleteMapping ("/delete")
    @ResponseBody
    public String delete(){

        indexservice.delete(); // new 를 사용하지 않아도 메소드 호출 가능

        return "삭제 성공";
    }
}
