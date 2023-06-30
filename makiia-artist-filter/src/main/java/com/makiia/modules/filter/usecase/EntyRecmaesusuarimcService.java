package com.makiia.modules.filter.usecase;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.makiia.crosscutting.domain.model.EntyDeleteDto;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcDto;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcResponse;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.modules.filter.dataproviders.jpa.JpaEntyRecmaesusuarimcDataProviders;
import com.makiia.modules.filter.services.UseCase;
import com.makiia.modules.filter.services.UsecaseServices;
@UseCase
public class EntyRecmaesusuarimcService extends UsecaseServices<EntyRecmaesusuarimcDto, JpaEntyRecmaesusuarimcDataProviders>
{
    @Autowired
    private JpaEntyRecmaesusuarimcDataProviders jpaDataProviders;
    @PostConstruct
    public void init(){
        this.ijpaDataProvider = jpaDataProviders;
    }

    private String localYear;
    private int year;

    public EntyRecmaesusuarimcResponse saveBefore(EntyRecmaesusuarimcResponse dto) throws EBusinessException {
        try{
            List<EntyRecmaesusuarimcDto>  dtoAux = this.ijpaDataProvider.save(dto.getRspData());
            localYear = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
            year = Integer.parseInt(localYear);
             for(EntyRecmaesusuarimcDto dtox : dtoAux){    
                if (dtox.getRecNroregRemc().equals("NA")) {
                dtox.setRecNroregRemc(year+""+dtox.getRecUnikeyRemc());
                }
             }
            dtoAux = this.ijpaDataProvider.save(dtoAux);       
            dto.setRspMessage("OK");
            dto.setRspValue("OK");
            dto.setRspAppKey("NA");
            dto.setRspAppKey("NA");
            dto.setRspData(dtoAux);
            return dto;
        }catch (PersistenceException | DataAccessException e){
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    public EntyRecmaesusuarimcResponse updateAll(EntyRecmaesusuarimcResponse dto) throws EBusinessException {
        try {
            List<EntyRecmaesusuarimcDto> dtoAux = dto.getRspData();

            for (EntyRecmaesusuarimcDto dtox : dtoAux){
                dtox = this.ijpaDataProvider.update(dtox.getRecUnikeyRemc(),dtox);
            }
            dto.setRspMessage("OK");
            dto.setRspValue("OK");
            dto.setRspAppKey("NA");
            dto.setRspAppKey("NA");
            dto.setRspData(dtoAux);
            return dto;

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    public String deleteAll(List<EntyDeleteDto> dto) throws EBusinessException {
        try {

            for (EntyDeleteDto dtox : dto) {
                this.ijpaDataProvider.delete(dtox.getRecPKey());
            }
            return "OK";

        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }


}
