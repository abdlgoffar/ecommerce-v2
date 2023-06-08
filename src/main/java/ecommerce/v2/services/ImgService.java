package ecommerce.v2.services;


import ecommerce.v2.models.entities.Img;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImgService {
    public abstract String create(MultipartFile multipartFile);
    public abstract byte[] findOneById(String id);
    public abstract byte[] findByName(String name);

    public abstract List<Img> findAll();
}
