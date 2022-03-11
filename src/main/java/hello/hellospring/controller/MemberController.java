package hello.hellospring.controller;

import hello.hellospring.repository.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //스프링이 뜰 때 컨트롤러 동작을 할 수 있도록 하는 어노테이션
public class MemberController {

    private final MemberService memberService;

    @Autowired //멤서비스를 스프링이 스프링 컨테이너의 멤버 서비스를 가져다가 연결 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
