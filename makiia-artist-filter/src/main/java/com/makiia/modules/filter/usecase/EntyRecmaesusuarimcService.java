package com.makiia.modules.filter.usecase;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcDto;
import com.makiia.modules.bus.services.UseCase;
import com.makiia.modules.bus.services.UsecaseServices;
import com.makiia.modules.filter.dataproviders.jpa.JpaEntyRecmaesusuarimcDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@Log4j2
@UseCase
public class EntyRecmaesusuarimcService extends UsecaseServices<EntyRecmaesusuarimcDto, JpaEntyRecmaesusuarimcDataProviders>
{
    @Autowired
    private JpaEntyRecmaesusuarimcDataProviders jpaDataProviders;
    @PostConstruct
    public void init(){
        this.ijpaDataProvider = jpaDataProviders;
    }

}
