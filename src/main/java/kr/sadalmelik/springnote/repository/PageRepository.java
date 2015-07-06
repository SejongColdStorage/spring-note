package kr.sadalmelik.springnote.repository;


import kr.sadalmelik.springnote.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    @Query("select p from Page p join p.note n where n.urlPath= :noteUrlPath and p.parentPage is null")
    Page findRootPage(@Param("noteUrlPath") String noteUrlPath);
}
