package com.example.shop_itoverone.services;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

@Service
public class FirebaseService {
    private Storage store = StorageOptions.getDefaultInstance().getService();

    public String save(MultipartFile multipartFile) throws Exception{
        String imageName = String.valueOf(System.currentTimeMillis());
        BlobId blobId = BlobId.of("kristina-bf688.appspot.com", imageName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(multipartFile.getContentType())
                .build();
        store = StorageOptions.newBuilder()
                .setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream("kristina-bf688-firebase-adminsdk-ovbq6-0605066d56.json")))
                .build()
                .getService();
        store.create(blobInfo, multipartFile.getInputStream());
        return imageName;
    }

    public String getUrl(String filename){
        return "https://firebasestorage.googleapis.com/v0/b/kristina-bf688.appspot.com/o/"+filename+"?alt=media&token=d8b563ba-5fc0-4c5f-8fcc-1767e803a64f";
    }
}
