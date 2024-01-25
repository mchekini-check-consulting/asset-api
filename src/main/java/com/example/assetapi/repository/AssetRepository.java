package com.example.assetapi.repository;

import com.example.assetapi.document.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssetRepository extends MongoRepository<Asset, String> {

    List<Asset> findAllByAssetKey_Name(String name);
}
