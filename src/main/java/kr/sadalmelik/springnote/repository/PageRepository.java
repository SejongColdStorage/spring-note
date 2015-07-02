package kr.sadalmelik.springnote.repository;


import kr.sadalmelik.springnote.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

}
