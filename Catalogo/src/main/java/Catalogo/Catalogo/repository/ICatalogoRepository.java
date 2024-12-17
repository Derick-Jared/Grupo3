package Catalogo.Catalogo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Catalogo.Catalogo.model.CatalogoModel;
import jakarta.transaction.Transactional;

@Repository
public interface ICatalogoRepository extends CrudRepository <CatalogoModel,Integer> {
    
    @Query("SELECT c FROM CatalogoModel c WHERE c.tabla = 0")
    List<CatalogoModel> findAllTablas();

    @Query("SELECT c FROM CatalogoModel c WHERE c.descripcion_corta = :desc ")
    CatalogoModel findByDescripcionCorta(@Param("desc") String descripcion);

    @Query("SELECT c FROM CatalogoModel c WHERE c.tabla = :tabla")
    List<CatalogoModel> findItemsByTabla(@Param("tabla") int tabla);

    @Query("SELECT c FROM CatalogoModel c WHERE c.tabla = 0 and c.item = :tabla")
    CatalogoModel findTablaExist(@Param("tabla") int tabla);

    @Query("SELECT MAX(c.item) FROM CatalogoModel c WHERE c.tabla = 0")
    int findMaxTabla();

    @Query("SELECT MAX(c.item) FROM CatalogoModel c WHERE c.tabla = :tabla")
    int findMaxItemByTabla(@Param("tabla") int tabla);

    @Modifying
    @Transactional
    @Query("UPDATE CatalogoModel c set descripcion_corta = :desCorta, c.descripcion_larga = :desLarga, c.actualizado_en = :acDate, c.actualizado_por = :acBy where c.id = :id")
    int updateCatalogoItem(@Param("id") int id ,@Param("desCorta") String descCorta, @Param("desLarga") String desLarga, @Param("acDate") LocalDateTime acdate, @Param("acBy") int acBy);
}
