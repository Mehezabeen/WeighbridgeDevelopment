package com.weighbridge.admin.services;

import com.weighbridge.admin.dtos.MaterialMasterDto;
import com.weighbridge.admin.entities.QualityRange;
import com.weighbridge.admin.payloads.MaterialWithParameters;
import com.weighbridge.admin.payloads.QualityRangeResponse;

import java.util.List;

public interface MaterialMasterService {
    List<MaterialMasterDto> getAllMaterials();

    List<String> getAllMaterialNames();

    void deleteMaterial(String materialId);

    String createMaterialWithParameterAndRange(MaterialWithParameters materialWithParameters);

    List<String> getTypeWithMaterial(String materialName);

    List<MaterialWithParameters> getQualityRangesByMaterialNameAndMaterialTypeName(String materialName, String materialTypeName);
}
