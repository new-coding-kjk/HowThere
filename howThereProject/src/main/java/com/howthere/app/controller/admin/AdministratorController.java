package com.howthere.app.controller.admin;

import com.howthere.app.domain.AnnouncementDTO;
import com.howthere.app.domain.program.ProgramDTO;
import com.howthere.app.entity.member.Member;
import com.howthere.app.service.admin.AnnouncementService;
import com.howthere.app.service.house.HouseService;
import com.howthere.app.service.member.MemberService;
import com.howthere.app.service.program.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/administrator/*")
public class AdministratorController {
    private final ProgramService programService;
    private final MemberService memberService;
    private final AnnouncementService announcementService;
//    private final OneToOneService oneToOneService;
    private final HouseService houseService;
//    private final ReservationService reservationService;

    //http://localhost:10000/administrator/program
    @GetMapping("program")
    public void program() {;}

    //http://localhost:10000/administrator/stay
    @GetMapping("house")
    public void house() {;}

    //http://localhost:10000/administrator/reservation
    @GetMapping("reservation")
    public void reserve() {;}

    //http://localhost:10000/administrator/member
    @GetMapping("member")
    public void member() {;}

    //http://localhost:10000/administrator/notice
    @GetMapping("notice")
    public void notice() {;}

    //http://localhost:10000/administrator/notice/detail
    @GetMapping("notice/detail")
    public String noticeDetail() {
        return "/administrator/notice-detail";
    }

    //http://localhost:10000/administrator/notice/write
    @GetMapping("notice/write")
    public String noticeWrite() {
        return "/administrator/notice-write";
    }

    //http://localhost:10000/administrator/inquiry
    @GetMapping("inquiry")
    public void inquiry() {;}

    //http://localhost:10000/administrator/inquiry/detail
    @GetMapping("inquiry/detail")
    public String inquiryDetail() {
        return "/administrator/inquiry-detail";
    }

    //http://localhost:10000/administrator/inquiry/write
    @GetMapping("inquiry/write")
    public String inquiryWrite() {
        return "/administrator/inquiry-write";
    }

    //===============================================================REST

    @GetMapping("api/inquiry")
    @ResponseBody
    public void inquiry(@PageableDefault Pageable pageable, String keyword) {

    }

    @GetMapping("api/program")
    @ResponseBody
    public Page<ProgramDTO> program(@PageableDefault Pageable pageable, String keyword) {
        return programService.getPrograms(pageable, keyword);
    }

    @GetMapping("api/notice")
    @ResponseBody
    public Page<AnnouncementDTO> notice(@PageableDefault Pageable pageable, String keyword) {
        return announcementService.getAnnouncementList(pageable, keyword);
    }

    @GetMapping("api/member")
    @ResponseBody
    public Page<Member> member(@PageableDefault Pageable pageable, String keyword) {
        return memberService.getMembers(pageable, keyword);
    }

    @GetMapping("api/house")
    @ResponseBody
    public void house(@PageableDefault Pageable pageable, String keyword) {
//        return houseService.getHouses();
    }

    @GetMapping("api/reservation")
    @ResponseBody
    public void reserve(@PageableDefault Pageable pageable, String keyword) {

    }
}
