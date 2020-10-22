package br.com.fernando.exemplo.scheduler.demo.repository;

import br.com.fernando.exemplo.scheduler.demo.entity.Restritiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface RestritivaRepository  extends JpaRepository<Restritiva,Long> {

    List<Restritiva> findAll();

    @Modifying
    @Query(value = "insert into TB056_Restritiva (id,cpf,data_hora) values (null,:cpf,current_timestamp())", nativeQuery = true)
    void insertRestritiva(@Param("cpf")String cpf);

    @Modifying
    @Query(value = "delete from TB056_Restritiva where data_hora <= :dataHora", nativeQuery = true)
    void deleteAllDia(@Param("dataHora")LocalDateTime dataHora);
}
