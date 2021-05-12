package ru.tablegame.schedule.trigger;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author nemykin 06.04.2021
 */
@Slf4j
public class AbstractTrigger {

    /**
     * Создаёт{@link JobDetailFactoryBean} для запуска в Spring Quartz
     *
     * @param jobClass    класс являющийся реализацией {@link Job}, на который будет создана джоба.
     * @param name        имя джобы
     * @param description описание джобы
     * @return {@link JobDetailFactoryBean}
     */
    public JobDetailFactoryBean createJobDetail(Class<? extends Job> jobClass,
                                                String name, String description) {
        log.debug("create Job Detail for {} with class {}", name, jobClass);
        var detailFactoryBean = new JobDetailFactoryBean();
        detailFactoryBean.setJobClass(jobClass);
        detailFactoryBean.setName(name);
        detailFactoryBean.setDescription(description);
        detailFactoryBean.setDurability(true);
        return detailFactoryBean;
    }

    /**
     * Создаёт правило {@link SimpleTriggerFactoryBean} для запуска в Spring Quartz
     *
     * @param jobDetail   {@link JobDetail}, на который будет создан триггер.
     * @param interval    интервал, с которым выполняется джоба
     * @param name        имя триггера
     * @param description описание триггера
     * @return {@link SimpleTriggerFactoryBean}
     */
    public SimpleTriggerFactoryBean createTrigger(JobDetail jobDetail, Long interval,
                                                  String name, String description) {
        log.debug("create  Trigger for $name with interval $interval", name, interval);
        var triggerFactoryBean = new SimpleTriggerFactoryBean();
        triggerFactoryBean.setJobDetail(jobDetail);
        triggerFactoryBean.setStartDelay(interval);
        triggerFactoryBean.setRepeatInterval(interval);
        triggerFactoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        triggerFactoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT);
        triggerFactoryBean.setName(name);
        triggerFactoryBean.setDescription(description);
        return triggerFactoryBean;
    }
}
