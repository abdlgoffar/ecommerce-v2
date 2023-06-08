package ecommerce.v2.controllers;

import ecommerce.v2.models.entities.Img;
import ecommerce.v2.services.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class ImgController {
    private ImgService imgService;
    @Autowired
    public void setImgService(ImgService imgService) {
        this.imgService = imgService;
    }

    @RequestMapping(value = "/v1/images/upload", method = RequestMethod.POST)
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String upload = this.imgService.create(multipartFile);
        return ResponseEntity.ok(upload);
    }
    @RequestMapping(value = "/v1/images/{name}", method = RequestMethod.GET)
    public ResponseEntity<?>download(@PathVariable("name") String name) throws IOException {
        byte[] img = this.imgService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("images/png"))
                .body(img);
    }
    @RequestMapping(value = "/v1/images", method = RequestMethod.GET)
    public Iterable<Img> findAll() {
        List<Img> all = this.imgService.findAll();
        return all;
    }
}
