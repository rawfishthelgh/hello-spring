package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //스프링이 뜰 때 컨트롤러 동작을 할 수 있도록 하는 어노테이션
public class MemberController {

    private final MemberService memberService;

    @Autowired //멤서비스를 스프링이 스프링 컨테이너의 멤버 서비스를 가져다가 연결 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        //모델에  "members" 로 member라는 리스트 전부 넣어줌
        model.addAttribute("members",members);
        return "members/memberlist";

    }
}
