package com.makiia.crosscutting.translate;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarimc;
import com.makiia.crosscutting.utils.GsonUtil;
import org.springframework.stereotype.Component;
@Component
public class EntyRecmaesusuarimcDtoToEntityTranslate implements Translator<EntyRecmaesusuarimcDto, EntyRecmaesusuarimc> {

    @Override
    public EntyRecmaesusuarimc translate(EntyRecmaesusuarimcDto input) throws EBusinessException {
        return GsonUtil.getGson(false)
                .fromJson(GsonUtil.getGson().toJson(input), EntyRecmaesusuarimc.class);
    }
}
