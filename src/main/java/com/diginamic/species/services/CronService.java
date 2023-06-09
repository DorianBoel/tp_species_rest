package com.diginamic.species.services;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {

	@Scheduled(cron = "${cron.schedule}")
	public void executeEveryMinute() {
		System.out.println("Exécution cron : " + LocalDateTime.now());
	}
}
