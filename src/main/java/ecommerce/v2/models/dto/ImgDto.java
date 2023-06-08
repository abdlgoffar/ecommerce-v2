package ecommerce.v2.models.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public class ImgDto {
    @Getter @Setter
    private String id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @Column
    private String type;
    @Getter @Setter
    @Column
    private String path;
}
