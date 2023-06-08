package ecommerce.v2.configurations.components;

import ecommerce.v2.lambda.Function2;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.LinkedHashSet;
import java.util.Set;

import java.util.function.Function;
@Component
@ToString
@Slf4j
public class Response<ENTITY, DTO> {
    @Getter
    @Setter
    private boolean status;
    @Getter @Setter
    private Set<String> messages = new LinkedHashSet<>();
    @Getter @Setter
    private ENTITY payload;
    private ValidatorFactory validatorFactory;
    private Validator validator;

    public Response() {
        this.validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }
    public ResponseEntity<Response<ENTITY, DTO>> create(Function<ENTITY, ENTITY> service,
                                                            ModelMapper modelMapper,
                                                            Class<ENTITY> entityClass,
                                                             DTO dto,
                                                             Class groupValidator) {
        Response<ENTITY, DTO> response = new Response<>();
        Set<ConstraintViolation<Object>> validate = this.validator.validate(dto, groupValidator);
        if (validate.isEmpty() == false) {
            response.setStatus(false);
            for (ConstraintViolation<Object> i : validate) {
                response.getMessages().add(i.getMessage() + " value not valid is " + i.getInvalidValue());
            }
            response.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.setStatus(true);
            ENTITY map = modelMapper.map(dto, entityClass);
            ENTITY apply = service.apply(map);

            response.setPayload(apply);
            log.info(response.getPayload().toString());
            return ResponseEntity.ok(response);
        }
    }
    public ResponseEntity<Response<ENTITY, DTO>> update(Function2<ENTITY, String, ENTITY> service,
                                                        ModelMapper modelMapper,
                                                        Class<ENTITY> entityClass,
                                                        DTO dto,
                                                        String id,
                                                        Class groupValidator) {
        Response<ENTITY, DTO> response = new Response<>();
        Set<ConstraintViolation<Object>> validate = this.validator.validate(dto, groupValidator);
        if (validate.isEmpty() == false) {
            response.setStatus(false);
            for (ConstraintViolation<Object> i : validate) {
                response.getMessages().add(i.getMessage() + " value not valid is " + i.getInvalidValue());
            }
            response.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            ENTITY map = modelMapper.map(dto, entityClass);
            ENTITY apply = service.apply(map, id);
            if (apply == null) {
                response.setStatus(false);
                response.setPayload(null);
                response.getMessages().add("data with id " + id + " not available");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            } else {
                response.setStatus(true);
                response.setPayload(apply);
                log.info(response.getPayload().toString());
                return ResponseEntity.ok(response);
            }
        }
    }
}
