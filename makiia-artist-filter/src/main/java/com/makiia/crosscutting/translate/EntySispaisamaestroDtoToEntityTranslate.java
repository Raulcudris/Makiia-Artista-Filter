package com.makiia.crosscutting.translate;
import com.makiia.crosscutting.domain.model.EntySispaisamaestroDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarimc;
import com.makiia.crosscutting.utils.GsonUtil;
import org.springframework.stereotype.Component;
@Component
public class EntySispaisamaestroDtoToEntityTranslate implements Translator<EntySispaisamaestroDto, EntyRecmaesusuarimc> {

    @Override
    public EntyRecmaesusuarimc translate(EntySispaisamaestroDto input) throws EBusinessException {
        return GsonUtil.getGson(false)
                .fromJson(GsonUtil.getGson().toJson(input), EntyRecmaesusuarimc.class);
    }
}
