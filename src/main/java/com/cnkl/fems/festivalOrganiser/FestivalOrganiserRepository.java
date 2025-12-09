package com.cnkl.fems.festivalOrganiser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestivalOrganiserRepository extends JpaRepository<FestivalOrganiser, Long> {
}
