package kr.co.luna.guestbook;

import ch.qos.logback.core.net.SyslogOutputStream;
import kr.co.luna.guestbook.dto.GuestBookDTO;
import kr.co.luna.guestbook.dto.PageRequestDTO;
import kr.co.luna.guestbook.dto.PageResponseDTO;
import kr.co.luna.guestbook.entity.GuestBook;
import kr.co.luna.guestbook.service.GuestBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestBookServiceTest {
    @Autowired
    private GuestBookService service;

   // @Test
    public void registerTest(){
        GuestBookDTO dto = GuestBookDTO.builder()
                .title("제목")
                .content("내용")
                .writer("루나")
                .build();
        Long gno = service.register(dto);
        System.out.println(gno);
    }
    @Test
    public void listTest(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        PageResponseDTO<GuestBookDTO, GuestBook>
                pageResponseDTO = service.getList(pageRequestDTO);
        for(GuestBookDTO dto : pageResponseDTO.getDtoList()){
            System.out.println(dto);
        }

        //이전과 다음 링크 여부와 전체 페이지 개수 확인
        System.out.println("====================================");
        System.out.println("이전:" + pageResponseDTO.isPrev());
        System.out.println("다음:" + pageResponseDTO.isNext());
        System.out.println("전체:" + pageResponseDTO.getTotalPage());
        //페이지 번호 목록 출력
        System.out.println("=====================================");
        for(Integer i : pageResponseDTO.getPageList()){
            System.out.print(i + "\t");
        }

    }
}
