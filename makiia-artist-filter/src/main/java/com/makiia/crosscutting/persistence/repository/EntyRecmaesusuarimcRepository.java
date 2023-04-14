package com.makiia.crosscutting.persistence.repository;
import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarimc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EntyRecmaesusuarimcRepository extends JpaRepository<EntyRecmaesusuarimc,String>
{
        String FILTER_COUNTRIES_CODCOUNTRIES_QUERY = "select c from EntySispaisamaestro c  where c.sisCodpaiSipa  = ?1";
        @Query(value = FILTER_COUNTRIES_CODCOUNTRIES_QUERY)
        Page<EntyRecmaesusuarimc> findCodCountry(String parameter, Pageable pageable);

        String FILTER_COUNTRIES_NAMECOUNTRY_QUERY = "select c from EntySispaisamaestro c where UPPER(c.sisNombreSipa) like concat('%',upper(?1),'%')";
        @Query(value = FILTER_COUNTRIES_NAMECOUNTRY_QUERY)
        Page<EntyRecmaesusuarimc> findNameCountry(String filter, Pageable pageable);

        Optional<EntyRecmaesusuarimc> findById(String id);

}
