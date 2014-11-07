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

import com.msiops.footing.functional.Fun1;
import com.msiops.footing.functional.Fun2;
import com.msiops.footing.functional.Fun3;
import com.msiops.footing.functional.Fun4;
import com.msiops.footing.functional.Fun5;

public class SimpleFunTest {

    @Test
    public void testFun1() {

        final Object r = new Object();

        final Fun1<Object, Object> f = t1 -> r;

        assertEquals(r, f.apply(new Object()));

    }

    @Test
    public void testFun2() {

        final Object r = new Object();

        final Fun2<Object, Object, Object> f = (t1, t2) -> r;

        assertEquals(r, f.apply(new Object(), new Object()));

    }

    @Test
    public void testFun3() {

        final Object r = new Object();

        final Fun3<Object, Object, Object, Object> f = (t1, t2, t3) -> r;

        assertEquals(r, f.apply(new Object(), new Object(), new Object()));

    }

    @Test
    public void testFun4() {

        final Object r = new Object();

        final Fun4<Object, Object, Object, Object, Object> f = (t1, t2, t3, t4) -> r;

        assertEquals(r,
                f.apply(new Object(), new Object(), new Object(), new Object()));

    }

    @Test
    public void testFun5() {

        final Object r = new Object();

        final Fun5<Object, Object, Object, Object, Object, Object> f = (t1, t2,
                t3, t4, t5) -> r;

        assertEquals(r, f.apply(new Object(), new Object(), new Object(),
                new Object(), new Object()));

    }

}
