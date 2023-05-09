package com.makiia.modules.filter.dataproviders.jpa;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcDto;
import com.makiia.crosscutting.domain.model.EntyRecmaesusuarimcResponse;
import com.makiia.crosscutting.domain.model.PaginationResponse;
import com.makiia.crosscutting.exceptions.DataProvider;
import com.makiia.crosscutting.exceptions.ExceptionBuilder;
import com.makiia.crosscutting.exceptions.Main.EBusinessException;
import com.makiia.crosscutting.messages.SearchMessages;
import com.makiia.crosscutting.patterns.Translator;
import com.makiia.crosscutting.persistence.entity.EntyRecmaesusuarimc;
import com.makiia.crosscutting.persistence.repository.EntyRecmaesusuarimcRepository;
import com.makiia.modules.filter.dataproviders.IjpaEntyRecmaesusuarimcDataProviders;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j2
@DataProvider
public class JpaEntyRecmaesusuarimcDataProviders implements IjpaEntyRecmaesusuarimcDataProviders {

    @Autowired
    private EntyRecmaesusuarimcRepository repository;
    @Autowired
    @Qualifier("entyRecmaesusuarimcSaveResponseTranslate")
    private Translator<EntyRecmaesusuarimc, EntyRecmaesusuarimcDto>saveResponseTranslate;
    @Autowired
    @Qualifier("entyRecmaesusuarimcDtoToEntityTranslate")
    private Translator<EntyRecmaesusuarimcDto, EntyRecmaesusuarimc>dtoToEntityTranslate;

    @Override
    public List<EntyRecmaesusuarimcDto> getAll() throws EBusinessException {
        List<EntyRecmaesusuarimcDto> dtos = new ArrayList<>();
        try {
            List<EntyRecmaesusuarimc> responses = (List<EntyRecmaesusuarimc>) repository.findAll();

            if (!responses.isEmpty()) {
                for (EntyRecmaesusuarimc response : responses) {
                    dtos.add(saveResponseTranslate.translate(response));
                }
            }

            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }
    @Override
    public EntyRecmaesusuarimcResponse getAll(int currentPage , int totalPageSize , int parameter, String filter) throws EBusinessException {
        try {
            currentPage = currentPage - 1;
            Pageable pageable = PageRequest.of(currentPage, totalPageSize);
            Page<EntyRecmaesusuarimc> ResponsePage = null;
            if (parameter == 0) {
                ResponsePage = repository.findByRecNroregRemc(filter, pageable);
            }else {
                ResponsePage = repository.findByRecUnikeyRemc(parameter,pageable);
            }

            List<EntyRecmaesusuarimc> ListPage = ResponsePage.getContent();
            List<EntyRecmaesusuarimcDto> content  = ListPage.stream().map(p ->mapToDto(p)).collect(Collectors.toList());

            EntyRecmaesusuarimcResponse response = new EntyRecmaesusuarimcResponse();
            response.setRspMessage(response.getRspMessage());
            response.setRspValue(response.getRspValue());

            currentPage = currentPage + 1;
            String nextPageUrl = "LocalHost";
            String previousPageUrl = "LocalHost";
            response.setRspPagination(headResponse(currentPage, totalPageSize, ResponsePage.getTotalElements(), ResponsePage.getTotalPages(), ResponsePage.hasNext(), ResponsePage.hasPrevious(), nextPageUrl, previousPageUrl));
            response.setRspData(content);
            return response;


        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }
    @Override
    public EntyRecmaesusuarimcDto get(Integer id) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.SEARCH_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.SEARCH_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaesusuarimcDto save(EntyRecmaesusuarimcDto dto) throws EBusinessException {
        try {
            return saveResponseTranslate.translate(repository.save(dtoToEntityTranslate.translate(dto)));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public List<EntyRecmaesusuarimcDto> save(List<EntyRecmaesusuarimcDto> dtos) throws EBusinessException {
        try {
            List<EntyRecmaesusuarimc> entities = new ArrayList<>();

            for (EntyRecmaesusuarimcDto dto : dtos) {
                entities.add(dtoToEntityTranslate.translate(dto));
            }
            dtos = new ArrayList<>();
            for (EntyRecmaesusuarimc entity : repository.saveAll(entities)) {
                dtos.add(saveResponseTranslate.translate(entity));
            }
            return dtos;
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.CREATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.CREATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    @Override
    public EntyRecmaesusuarimcDto update(Integer id, EntyRecmaesusuarimcDto dto) throws EBusinessException {
        try {
            EntyRecmaesusuarimc entity = dtoToEntityTranslate.translate(dto);
            EntyRecmaesusuarimc old = repository.findById(id).get();

            old.setRecUnikeyRemc(
                    Objects.nonNull(dto.getRecUnikeyRemc())&& !entity.getRecUnikeyRemc().equals(0)
                            ? entity.getRecUnikeyRemc()
                            :old.getRecUnikeyRemc());

            old.setRecNroregRemc(
                    Objects.nonNull(dto.getRecNroregRemc())&& !entity.getRecNroregRemc().isEmpty()
                            ? entity.getRecNroregRemc()
                            :old.getRecNroregRemc());

            old.setRecNroregReus(
                    Objects.nonNull(dto.getRecNroregReus())&& !entity.getRecNroregReus().isEmpty()
                            ? entity.getRecNroregReus()
                            :old.getRecNroregReus());


            old.setRecNtokenReus(
                    Objects.nonNull(dto.getRecNtokenReus())&& !entity.getRecNtokenReus().isEmpty()
                            ? entity.getRecNtokenReus()
                            :old.getRecNtokenReus());

            old.setRecTipfilRemc(
                    Objects.nonNull(dto.getRecTipfilRemc())&& !entity.getRecTipfilRemc().isEmpty()
                            ? entity.getRecTipfilRemc()
                            :old.getRecTipfilRemc());

            old.setRecModuloRemc(
                    Objects.nonNull(dto.getRecModuloRemc())&& !entity.getRecModuloRemc().isEmpty()
                            ? entity.getRecModuloRemc()
                            :old.getRecModuloRemc());

            old.setSisCodpaiSipa(
                    Objects.nonNull(dto.getSisCodpaiSipa())&& !entity.getSisCodpaiSipa().isEmpty()
                            ? entity.getSisCodpaiSipa()
                            :old.getSisCodpaiSipa());

            old.setSisIdedptSidp(
                    Objects.nonNull(dto.getSisIdedptSidp())&& !entity.getSisIdedptSidp().isEmpty()
                            ? entity.getSisIdedptSidp()
                            :old.getSisIdedptSidp());

            old.setSisCodproSipr(
                    Objects.nonNull(dto.getSisCodproSipr())&& !entity.getSisCodproSipr().isEmpty()
                            ? entity.getSisCodproSipr()
                            :old.getSisCodproSipr());

            old.setRecGeodisRemc(
                    Objects.nonNull(dto.getRecGeodisRemc())&& !entity.getRecGeodisRemc().equals(0)
                            ? entity.getRecGeodisRemc()
                            :old.getRecGeodisRemc());

            old.setRecGeolatReus(
                    Objects.nonNull(dto.getRecGeolatReus())&& !entity.getRecGeolatReus().equals(0)
                            ? entity.getRecGeolatReus()
                            :old.getRecGeolatReus());

            old.setRecGeolonReus(
                    Objects.nonNull(dto.getRecGeolonReus())&& !entity.getRecGeolonReus().equals(0)
                            ? entity.getRecGeolonReus()
                            :old.getRecGeolonReus());

            old.setRecGenmusReus(
                    Objects.nonNull(dto.getRecGenmusReus())&& !entity.getRecGenmusReus().isEmpty()
                            ? entity.getRecGenmusReus()
                            :old.getRecGenmusReus());

            old.setRecFecagiRemc(
                    Objects.nonNull(dto.getRecFecagiRemc())&& !entity.getRecFecagiRemc().equals(0)
                            ? entity.getRecFecagiRemc()
                            :old.getRecFecagiRemc());

            old.setRecFecagfRemc(
                    Objects.nonNull(dto.getRecFecagfRemc())&& !entity.getRecFecagfRemc().equals(0)
                            ? entity.getRecFecagfRemc()
                            :old.getRecFecagfRemc());

            old.setRecDiapunRemc(
                    Objects.nonNull(dto.getRecDiapunRemc())&& !entity.getRecDiapunRemc().equals(0)
                            ? entity.getRecDiapunRemc()
                            :old.getRecDiapunRemc());

            old.setRecKeyfilRemc(
                    Objects.nonNull(dto.getRecKeyfilRemc())&& !entity.getRecKeyfilRemc().isEmpty()
                            ? entity.getRecKeyfilRemc()
                            :old.getRecKeyfilRemc());

            old.setRecKeytmpRemc(
                    Objects.nonNull(dto.getRecKeytmpRemc())&& !entity.getRecKeytmpRemc().isEmpty()
                            ? entity.getRecKeytmpRemc()
                            :old.getRecKeytmpRemc());

            old.setRecKeytm1Remc(
                    Objects.nonNull(dto.getRecKeytm1Remc())&& !entity.getRecKeytm1Remc().isEmpty()
                            ? entity.getRecKeytm1Remc()
                            :old.getRecKeytm1Remc());

            old.setRecKeytm2Remc(
                    Objects.nonNull(dto.getRecKeytm2Remc())&& !entity.getRecKeytm2Remc().isEmpty()
                            ? entity.getRecKeytm2Remc()
                            :old.getRecKeytm2Remc());

            old.setRecKeytm3Remc(
                    Objects.nonNull(dto.getRecKeytm3Remc())&& !entity.getRecKeytm3Remc().isEmpty()
                            ? entity.getRecKeytm3Remc()
                            :old.getRecKeytm3Remc());

            old.setRecKeytm4Remc(
                    Objects.nonNull(dto.getRecKeytm4Remc())&& !entity.getRecKeytm4Remc().isEmpty()
                            ? entity.getRecKeytm4Remc()
                            :old.getRecKeytm4Remc());

            old.setRecEstregRemc(
                    Objects.nonNull(dto.getRecEstregRemc())&& !entity.getRecEstregRemc().equals(0)
                            ? entity.getRecEstregRemc()
                            :old.getRecEstregRemc());



            return saveResponseTranslate.translate(repository.save(old));
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.UPDATE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.UPDATE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();

        }
    }

    @Override
    public void delete(Integer id) throws EBusinessException {
        try {
            repository.delete(repository.findById(id).get());
        } catch (PersistenceException | DataAccessException e) {
            throw ExceptionBuilder.builder()
                    .withMessage(SearchMessages.DELETE_ERROR_DESCRIPTION)
                    .withCode(SearchMessages.DELETE_ERROR_ID)
                    .withParentException(e)
                    .buildBusinessException();
        }
    }

    private EntyRecmaesusuarimcDto mapToDto(EntyRecmaesusuarimc entyRecmaesusuarimc){
        EntyRecmaesusuarimcDto dto = new EntyRecmaesusuarimcDto();

        dto.setRecUnikeyRemc(entyRecmaesusuarimc.getRecUnikeyRemc());
        dto.setRecNroregRemc(entyRecmaesusuarimc.getRecNroregRemc());
        dto.setRecNroregReus(entyRecmaesusuarimc.getRecNroregReus());
        dto.setRecNtokenReus(entyRecmaesusuarimc.getRecNtokenReus());
        dto.setRecTipfilRemc(entyRecmaesusuarimc.getRecTipfilRemc());
        dto.setRecModuloRemc(entyRecmaesusuarimc.getRecModuloRemc());
        dto.setSisCodpaiSipa(entyRecmaesusuarimc.getSisCodpaiSipa());
        dto.setSisIdedptSidp(entyRecmaesusuarimc.getSisIdedptSidp());
        dto.setSisCodproSipr(entyRecmaesusuarimc.getSisCodproSipr());
        dto.setRecGeodisRemc(entyRecmaesusuarimc.getRecGeodisRemc());
        dto.setRecGeolatReus(entyRecmaesusuarimc.getRecGeolatReus());
        dto.setRecGeolonReus(entyRecmaesusuarimc.getRecGeolonReus());
        dto.setRecGenmusReus(entyRecmaesusuarimc.getRecGenmusReus());
        dto.setRecFecagiRemc(entyRecmaesusuarimc.getRecFecagiRemc());
        dto.setRecFecagfRemc(entyRecmaesusuarimc.getRecFecagfRemc());
        dto.setRecDiapunRemc(entyRecmaesusuarimc.getRecDiapunRemc());
        dto.setRecKeyfilRemc(entyRecmaesusuarimc.getRecKeyfilRemc());
        dto.setRecKeytmpRemc(entyRecmaesusuarimc.getRecKeytmpRemc());
        dto.setRecKeytm1Remc(entyRecmaesusuarimc.getRecKeytm1Remc());
        dto.setRecKeytm2Remc(entyRecmaesusuarimc.getRecKeytm2Remc());
        dto.setRecKeytm3Remc(entyRecmaesusuarimc.getRecKeytm3Remc());
        dto.setRecKeytm4Remc(entyRecmaesusuarimc.getRecKeytm4Remc());
        dto.setRecEstregRemc(entyRecmaesusuarimc.getRecEstregRemc());
        return  dto;
    }

    public static PaginationResponse headResponse(int currentPage    , int totalPageSize ,
                                                  long totalResults  , int totalPages,
                                                  boolean hasNextPage, boolean hasPreviousPage,
                                                  String nextpageUrl , String previousPageUrl )
    {
        return PaginationResponse.builder()
                .currentPage(currentPage)
                .totalPageSize(totalPageSize)
                .totalResults(totalResults)
                .totalPages(totalPages)
                .hasNextPage(hasNextPage)
                .hasPreviousPage(hasPreviousPage)
                .nextPageUrl(nextpageUrl)
                .previousPageUrl(previousPageUrl)
                .build();

    }
}
