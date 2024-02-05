package com.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/products/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/products/_post/product_rq.json")
@ResponseTemplatePath(path = "api/products/_post/product_rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostProduct extends AbstractApiMethodV2 {

    public PostProduct() {
        super(null, "api/products/_post/product_rs.json");

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}

