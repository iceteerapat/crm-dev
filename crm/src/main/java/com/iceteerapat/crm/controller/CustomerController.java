package com.iceteerapat.crm.controller;

import com.iceteerapat.crm.model.Customer;
import com.iceteerapat.crm.model.Response;
import com.iceteerapat.crm.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/lists")
    public ResponseEntity<Response> getCustomers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("customer",customerService.list(10)))
                        .message("Retrieved Customers")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getId(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("customer", Optional.ofNullable(customerService.get(id)).orElseThrow(() -> new IllegalArgumentException("Customer not found with ID: " + id))))
                        .message("Retrieved Customer ID")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCustomer(@RequestBody @Valid Customer customer){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("customer",customerService.create(customer)))
                        .message("Customer has created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteId(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("customer",customerService.delete(id)))
                        .message("Customer has been deleted")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @Value("${image.profile.path}")
    private String imageProfilePath;
    @GetMapping(path = "/image/{imageProfile}", produces = IMAGE_JPEG_VALUE)
    public byte[] getImageProfile(@PathVariable("imageProfile") String imageProfile) throws Exception {
        Path imagePath = null;

        String [] drives = {"C", "D", "E", "F"};

        for(String drive : drives){
            Path pathPotential = Paths.get(drive + ":" + imageProfilePath + imageProfile);
            if (Files.exists(pathPotential)){
                imagePath = pathPotential;
                break;
            }
        }

        if(imagePath != null){
            return Files.readAllBytes(imagePath);
        }else {
            throw new Exception("Image File not Found");
        }
    }
}
