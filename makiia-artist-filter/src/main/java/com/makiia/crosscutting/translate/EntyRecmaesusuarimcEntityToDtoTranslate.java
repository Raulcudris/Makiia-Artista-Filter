package com.makiia.crosscutting.translate;

import org.springframework.stereotype.Component;

import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarimc;
import com.makiia.crosscutting.utils.GsonUtil;
@Component
public class EntyRecmaesusuarimcEntityToDtoTranslate implements Translator<EntyRecmaesusuarimc, EntyRecmaesusuarimcDto> {
    @Override
    public EntyRecmaesusuarimcDto translate(EntyRecmaesusuarimc input) throws EBusinessException {
        return GsonUtil.getGson().fromJson(GsonUtil.getGson().toJson(input), EntyRecmaesusuarimcDto.class);
    }
}
