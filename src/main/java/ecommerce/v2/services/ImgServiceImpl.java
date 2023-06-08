package ecommerce.v2.services;

import ecommerce.v2.configurations.components.IDGenerator;
import ecommerce.v2.models.entities.Img;
import ecommerce.v2.models.repositories.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService{
    private ImgRepository imgRepository;
    @Autowired
    public void setImgRepository(ImgRepository imgRepository) {
        this.imgRepository = imgRepository;
    }
    private IDGenerator idGenerator;
    @Autowired
    public void setIdGenerator(IDGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    private final String path = "C:/Users/abd.goffar/Documents/";
    @Override
    public String create(MultipartFile multipartFile) {
        //save img data to database
        Img save = this.imgRepository.save(new Img(
                this.idGenerator.generate(),
                multipartFile.getOriginalFilename(),
                multipartFile.getContentType(),
                this.path + multipartFile.getOriginalFilename()));
        //save img binary file to hdd server
        try {
            multipartFile.transferTo(new File(this.path + multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (save != null) return "uploaded img successfully";
        return "uploaded img failed";
    }

    @Override
    public byte[] findOneById(String id) {
        Img img = this.imgRepository.findById(id).get();
        try {
            byte[] bytes = Files.readAllBytes(new File(img.getPath()).toPath());
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] findByName(String name) {
        Img img = this.imgRepository.findByName(name).get();
        try {
            byte[] bytes = Files.readAllBytes(new File(img.getPath()).toPath());
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Img> findAll() {
        List<Img> all = this.imgRepository.findAll();
        return all;
    }
}
