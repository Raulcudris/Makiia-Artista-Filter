package com.makiia.modules.filter.dataproviders;
import com.makiia.crosscutting.domain.model.EntySispaisamaestroDto;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.modules.bus.contracts.IjpaDataProviders;

public interface IjpaEntyRecmaesusuarimcDataProviders extends IjpaDataProviders<EntySispaisamaestroDto> {
  EntySispaisamaestroDto update(String id , EntySispaisamaestroDto dto)throws EBusinessException;
  void delete(String id ) throws  EBusinessException;
}
