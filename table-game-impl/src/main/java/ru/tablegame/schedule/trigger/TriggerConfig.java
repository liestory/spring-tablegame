package ru.tablegame.schedule.trigger;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.stereotype.Component;
import ru.tablegame.schedule.job.SurpriseAttackJob;

/**
 * настройки на выполнения заданий по засаде врагов
 *
 * @author nemykin 07.04.2021
 */
@Slf4j
@Component
@ConditionalOnProperty(prefix = "scheduling.cron", name = {"enabled"}, matchIfMissing = false)
public class TriggerConfig extends AbstractTrigger {

    @Bean
    public JobDetailFactoryBean getJobDetail() {
        return createJobDetail(SurpriseAttackJob.class, SurpriseAttackJob.class.getSimpleName(),
                "Задание на проверку возможности засады врагов");
    }

    @Bean(name = "surpriseAttackJobTrigger")
    public SimpleTriggerFactoryBean jobTrigger(@Qualifier("getJobDetail") JobDetail jobDetail,
                                               @Value("${scheduling.surpriseAttackSchedule.interval}") Long time) {
        return createTrigger(jobDetail, time, "surpriseAttackJobTrigger",
                "Запуск проверки на засаду врагов");
    }

}
