package com.example.assetapi.resource;

import com.example.assetapi.document.Asset;
import com.example.assetapi.dto.SearchCriteria;
import com.example.assetapi.service.AssetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetResource {

    private final AssetService assetService;

    public AssetResource(AssetService assetService) {
        this.assetService = assetService;
    }


    @GetMapping
    public List<Asset> getAllAssets(@RequestBody SearchCriteria searchCriteria) {
        return assetService.getAllAssets(searchCriteria);
    }
}
