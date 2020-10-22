package br.com.fernando.exemplo.scheduler.demo.schedule;

import br.com.fernando.exemplo.scheduler.demo.service.RestritivaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ScheduleTask {

    @Autowired
    private RestritivaService service;

    @Scheduled(cron = "${cron.expression}")
    public void inicioSchedulerInsert() {
        log.info("Iniciando Rotina de insert...");

        log.info("Inserindo os dados");
        List<String> lista = new  ArrayList<>();
        lista.add("07968831067");
        lista.add("79122292055");
        lista.add("22487572043");
        lista.add("55572395021");
        lista.add("55572395021");
        lista.add("07968831067");
        this.service.insert(lista);
        log.info("Dados inseridos com sucesso.");
        log.info("Listando todos ");
        log.info(this.service.findAll().toString());
        log.info("Listado com sucesso!");

    }

    @Scheduled(cron = "${cron.expression.delete}")
    public void inicioSchedulerDelete() {

        log.info("Iniciando Rotina de delete...");
        Long minutos = 2L;
        log.info("Deletando dados de {} minutos atraz",minutos );
        this.service.deleteMinus(minutos);
        log.info("Deletado com sucesso!");
    }

}