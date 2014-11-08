/**
 * Licensed to Media Science International (MSI) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. MSI
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package fn.com.msiops.footing.functional;

import static org.junit.Assert.*;

import org.junit.Test;

import com.msiops.footing.functional.SupplierX;

public class SupplierXTest {

    private static final SupplierX<Integer, Exception> S1 = () -> 211;

    private static final SupplierX<Integer, Exception> SX1;

    private static final Exception X = new Exception();

    static {
        SX1 = () -> {
            throw X;
        };
    }

    @Test
    public void testFunX1Throws() {

        try {
            SX1.get();
            fail("should throw");
        } catch (final Exception x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testSupplierX() throws Exception {

        assertEquals(211, S1.get().intValue());

    }

}
