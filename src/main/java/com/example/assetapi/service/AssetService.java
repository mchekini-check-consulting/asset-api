package com.example.assetapi.service;


import com.example.assetapi.document.Asset;
import com.example.assetapi.document.AssetKey;
import com.example.assetapi.dto.SearchCriteria;
import com.example.assetapi.repository.AssetRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @PostConstruct
    public void initData() {


        Asset asset1 = Asset.builder()
                .assetKey(AssetKey.builder().timestamp(LocalDateTime.now().minusMinutes(1L)).name("MICROSOFT").build())
                .value(152.0)
                .build();

        Asset asset2 = Asset.builder()
                .assetKey(AssetKey.builder().timestamp(LocalDateTime.now()).name("MICROSOFT").build())
                .value(154.0)
                .build();

        assetRepository.saveAll(List.of(asset1, asset2));

    }

    public List<Asset> getAllAssets(SearchCriteria searchCriteria) {
        return assetRepository.findAllByAssetKey_Name(searchCriteria.getName());
    }
}
