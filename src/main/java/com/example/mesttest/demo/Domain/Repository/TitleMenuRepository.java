package com.example.mesttest.demo.Domain.Repository;

import com.example.mesttest.demo.Domain.TitleMenu;
import com.example.mesttest.demo.Dto.menu.TitleMenuResDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleMenuRepository extends JpaRepository<TitleMenu,String> {
    TitleMenu findByTitleMenuName(String menuname);//delete시 사용됨
//    List<TitleMenuResDto> findAllByTitleMenuNameOrderByPriority(); //화면에 뿌려줄때 우선순위로 정렬
}
