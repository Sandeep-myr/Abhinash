package com.example.demo.model;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

	@Autowired
	private ImageRepo imageRepo;

	@PostMapping("/sendImage")
	public String saveImage( @RequestParam("file") MultipartFile tg, @RequestBody ImageReq mpf) throws IOException {
		ImageEntity entity = new ImageEntity();

		entity.setImage(tg.getBytes());

		imageRepo.save(entity);

		return "image uploaded successfully";
	}

	@GetMapping("/getImage")
	public ImageEntity getImage() {
		// System.out.println(imageRepo.findById(11).get());
		return imageRepo.findById(11).get();
	}
}
