package com.edi.app.service;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.edi.app.entity.vm.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class S3Service {
    private  final  static String BUCKET = "fernedisxs3";

    @Autowired
    private AmazonS3Client s3Client;

    public String put0bject (MultipartFile multipartFile) {
        String extension = StringUtils.getFilenameExtension (multipartFile.getOriginalFilename());
        String key = String.format("%s.%s", UUID.randomUUID(), extension) ;

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());
        try{
        PutObjectRequest put0bjectRequest = new PutObjectRequest (BUCKET, key, multipartFile.getInputStream(), objectMetadata) ;
        s3Client.putObject(put0bjectRequest) ;
        return key;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Asset getObject (String key){
        S3Object s30bject = s3Client.getObject (BUCKET, key);
        ObjectMetadata metadata = s30bject.getObjectMetadata();

        try {
            S3ObjectInputStream inputstrean = s30bject.getObjectContent();
            byte[] bytes = IOUtils.toByteArray(inputstrean);

            return new Asset(bytes, metadata.getContentType());
        }catch (IOException ex) {
            throw new RuntimeException (ex) ;
        }
    }

    public void deleteObject(String key){
        s3Client.deleteObject(BUCKET,key);
    }

    public String getObjectUrl(String key){
        return String.format("https://%s.s3.amazonaws.com/%s", BUCKET,key);
    }

}
