package net.parduotube.parduotuvespringbootbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.parduotube.parduotuvespringbootbackend.model.ProductFromDatabase;

@Repository
public interface ProductRepository extends JpaRepository<ProductFromDatabase, Long> {

}
