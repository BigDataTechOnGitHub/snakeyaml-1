/**
 * Copyright (c) 2008-2013, http://www.snakeyaml.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yaml.snakeyaml.issues.issue177;

import junit.framework.TestCase;

import org.yaml.snakeyaml.Util;
import org.yaml.snakeyaml.Yaml;

public class PointBeanTest extends TestCase {

    public void testNoSingleQuoteForBlockStyle() throws Exception {
        String input = Util.getLocalResource("issues/issue177-1.yaml");
        try {
            Yaml yaml = new Yaml();
            yaml.load(input);
            fail();
        } catch (Exception e) {
            String error = Util.getLocalResource("issues/issue177-1.txt");
            assertEquals(error.trim(), e.getMessage());
        }
    }
}
