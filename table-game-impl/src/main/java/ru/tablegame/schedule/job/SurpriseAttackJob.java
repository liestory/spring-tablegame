package ru.tablegame.schedule.job;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import ru.tablegame.model.CharacterStatus;
import ru.tablegame.resource.dto.character.CharacterDto;
import ru.tablegame.service.CharacterService;

import java.util.List;

/**
 * служба-работа по засаде врагов
 *
 * @author nemykin 07.04.2021
 */
@AllArgsConstructor
@Slf4j
public class SurpriseAttackJob implements Job {
    private final CharacterService characterService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<CharacterDto> charactersDtos = characterService.getAllCharacters();
        List<CharacterDto> resultDtos = null;
        for (CharacterDto characterDto : charactersDtos) {
            if (characterDto.getStatusDesc().equals(CharacterStatus.ACTIVE.getDescription())
                    || characterDto.getStatusDesc().equals(CharacterStatus.IN_BATTLE.getDescription())) {
                resultDtos.add(characterDto);
                log.info("Персонаж {} может попасть в засаду врагов", characterDto.getCharacterName());
            }
        }
    }
}
