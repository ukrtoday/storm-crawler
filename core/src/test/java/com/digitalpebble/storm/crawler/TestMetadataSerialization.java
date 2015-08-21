/**
 * Licensed to DigitalPebble Ltd under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * DigitalPebble licenses this file to You under the Apache License, Version 2.0
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
package com.digitalpebble.storm.crawler;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import backtype.storm.Config;
import backtype.storm.serialization.KryoValuesDeserializer;
import backtype.storm.serialization.KryoValuesSerializer;
import backtype.storm.utils.Utils;

public class TestMetadataSerialization {

    @Test
    public void testSerialization() throws IOException {
        Map conf = Utils.readDefaultConfig();
        Config.registerSerialization(conf, Metadata.class);

        KryoValuesSerializer kvs = new KryoValuesSerializer(conf);
        Metadata md = new Metadata();
        byte[] content = kvs.serializeObject(md);

        KryoValuesDeserializer kvd = new KryoValuesDeserializer(conf);
        Metadata md2 = (Metadata) kvd.deserializeObject(content);

        // TODO compare md1 and md2
    }

    @Test
    public void testLock() throws IOException {
        Metadata md = new Metadata();
        md.setValue("a", "1");
        md.setValue("b", "2");
        md.lock();
        boolean exception = false;
        try {
            md.setValue("c", "3");
        } catch (UnsupportedOperationException e) {
            exception = true;
        }
        Assert.assertEquals(true, exception);
    }
}
