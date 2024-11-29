package com.fl.repository.extension;

import com.fl.model.Extension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FindExtension extends JpaRepository<Extension, Integer> {
    Extension findByNom(String nom);
}
