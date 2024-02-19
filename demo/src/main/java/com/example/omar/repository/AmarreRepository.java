package com.example.omar.repository;

import com.example.omar.model.Amarre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AmarreRepository extends
        JpaRepository<Amarre, Long> {

}
