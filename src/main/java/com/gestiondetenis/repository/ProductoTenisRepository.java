package com.gestiondetenis.repository;

import com.gestiondetenis.model.ProductoTenis;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoTenisRepository extends MongoRepository<ProductoTenis, String> {
}
