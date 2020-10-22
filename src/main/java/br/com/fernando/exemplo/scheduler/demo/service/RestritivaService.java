package br.com.fernando.exemplo.scheduler.demo.service;

import br.com.fernando.exemplo.scheduler.demo.entity.Restritiva;
import br.com.fernando.exemplo.scheduler.demo.repository.RestritivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RestritivaService {

    @Autowired
    private RestritivaRepository restritivaRepository;

    @Transactional(readOnly = true)
    public List<Restritiva> findAll() {
        return this.restritivaRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void insert(List<String> cpf){
        cpf.forEach(c ->{
            this.restritivaRepository.insertRestritiva(c);
        });
    }

    @Transactional(readOnly = false)
    public void deleteMinus(Long min){
        this.restritivaRepository.deleteAllDia(LocalDateTime.now().minusMinutes(min));
    }

}
