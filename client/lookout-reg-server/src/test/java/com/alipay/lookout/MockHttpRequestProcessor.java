/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.lookout;

import com.alipay.lookout.remote.report.Address;
import com.alipay.lookout.remote.report.support.http.HttpRequestProcessor;
import com.alipay.lookout.remote.report.support.http.ResultConsumer;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Map;

/**
 * Created by kevin.luy@alipay.com on 2018/6/5.
 */
public class MockHttpRequestProcessor implements HttpRequestProcessor {

    public Object      request;
    private HttpEntity entity;

    @Override
    public boolean sendPostRequest(HttpPost httpPost, Map<String, String> metadata)
                                                                                   throws IOException {
        return false;
    }

    @Override
    public boolean sendGetRequest(HttpGet httpGet, Map<String, String> metadata) throws IOException {
        return false;
    }

    @Override
    public boolean sendGetRequest(HttpGet httpGet, Map<String, String> metadata,
                                  ResultConsumer resultConsumer) throws IOException {
        resultConsumer.consume(entity);
        return true;
    }

    @Override
    public Address getAvailableAddress() {
        return new Address("localhost", 8080);
    }

    public void setEntity(HttpEntity entity) {
        this.entity = entity;
    }
}
