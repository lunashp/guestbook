package kr.co.luna.guestbook.service;

import kr.co.luna.guestbook.dto.GuestBookDTO;
import kr.co.luna.guestbook.dto.PageRequestDTO;
import kr.co.luna.guestbook.dto.PageResponseDTO;
import kr.co.luna.guestbook.entity.GuestBook;

public interface GuestBookService {
    //DTO 클래스의 인스턴스를 Entity 인스턴스로 변환해주는 메소드
    default GuestBook dtoToEntity(GuestBookDTO dto){
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }
    //Entity 클래스의 인스턴스를 DTO 클래스의 인스턴스로 변환해주는 메소드
    default GuestBookDTO entityToDTO(GuestBook guestBook){
        GuestBookDTO dto = GuestBookDTO.builder()
                .gno(guestBook.getGno())
                .title(guestBook.getTitle())
                .content(guestBook.getContent())
                .writer(guestBook.getWriter())
                .regDate(guestBook.getRegDate())
                .modDate(guestBook.getModDate())
                .build();
        return dto;
    }
    //데이터 삽입을 위한 메소드
    public Long register(GuestBookDTO dto);

    //데이터 목록 보기를 위한 메소드
    public PageResponseDTO<GuestBookDTO, GuestBook> getList(
            PageRequestDTO requestDTO);

    //상세보기를 위한 메소드
    public GuestBookDTO read(Long gno);
        }
