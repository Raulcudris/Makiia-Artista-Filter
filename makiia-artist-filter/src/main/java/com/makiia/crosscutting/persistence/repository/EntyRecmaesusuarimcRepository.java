package com.makiia.crosscutting.persistence.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarimc;
public interface EntyRecmaesusuarimcRepository extends JpaRepository<EntyRecmaesusuarimc,Integer>
{
        String FILTER_USUARIO_RECUNIKEYREMC_QUERY = "select c from EntyRecmaesusuarimc c  where c.recUnikeyRemc  = ?1  and c.recEstregRemc = 1";
        @Query(value = FILTER_USUARIO_RECUNIKEYREMC_QUERY)
        Page<EntyRecmaesusuarimc> findByRecUnikeyRemc(Integer filter, Pageable pageable);
        String FILTER_USUARIO_RECNROREGREMC_QUERY = "select c from EntyRecmaesusuarimc c where UPPER(c.recNroregRemc) like concat('%',upper(?1),'%') and c.recEstregRemc = 1";
        @Query(value = FILTER_USUARIO_RECNROREGREMC_QUERY)
        Page<EntyRecmaesusuarimc> findByRecNroregRemc(String filter, Pageable pageable);

}
