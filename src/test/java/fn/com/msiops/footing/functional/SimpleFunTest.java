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

import com.msiops.footing.functional.Fun2;
import com.msiops.footing.functional.Fun3;
import com.msiops.footing.functional.Fun4;
import com.msiops.footing.functional.Fun5;

public class SimpleFunTest {

    private static final Fun2<Integer, Integer, Integer> F2 = (t1, t2) -> t1
            + t2;

    private static final Fun3<Integer, Integer, Integer, Integer> F3 = (t1, t2,
            t3) -> t1 + t2 + t3;

    private static final Fun4<Integer, Integer, Integer, Integer, Integer> F4 = (
            t1, t2, t3, t4) -> t1 + t2 + t3 + t4;

    private static final Fun5<Integer, Integer, Integer, Integer, Integer, Integer> F5 = (
            t1, t2, t3, t4, t5) -> t1 + t2 + t3 + t4 + t5;

    @Test
    public void testFun2() {

        assertEquals(7 + 11, F2.apply(7, 11).intValue());

    }

    @Test
    public void testFun3() {

        assertEquals(7 + 11 + 13, F3.apply(7, 11, 13).intValue());

    }

    @Test
    public void testFun4() {

        assertEquals(7 + 11 + 13 + 17, F4.apply(7, 11, 13, 17).intValue());

    }

    @Test
    public void testFun5() {

        assertEquals(7 + 11 + 13 + 17 + 19, F5.apply(7, 11, 13, 17, 19)
                .intValue());
    }

    @Test
    public void testReduceFun2By1() {

        assertEquals(F2.apply(7, 11), F2.apply(7).apply(11));

    }

    @Test
    public void testReduceFun3By1() {

        assertEquals(F3.apply(7, 11, 13), F3.apply(7).apply(11, 13));

    }

    @Test
    public void testReduceFun3By2() {

        assertEquals(F3.apply(7, 11, 13), F3.apply(7, 11).apply(13));

    }

    @Test
    public void testReduceFun4By1() {

        assertEquals(F4.apply(7, 11, 13, 17), F4.apply(7).apply(11, 13, 17));

    }

    @Test
    public void testReduceFun4By2() {

        assertEquals(F4.apply(7, 11, 13, 17), F4.apply(7, 11).apply(13, 17));

    }

    @Test
    public void testReduceFun4By3() {

        assertEquals(F4.apply(7, 11, 13, 17), F4.apply(7, 11, 13).apply(17));

    }

    @Test
    public void testReduceFun5By1() {

        assertEquals(F5.apply(7, 11, 13, 17, 19),
                F5.apply(7).apply(11, 13, 17, 19));

    }

    @Test
    public void testReduceFun5By2() {

        assertEquals(F5.apply(7, 11, 13, 17, 19),
                F5.apply(7, 11).apply(13, 17, 19));

    }

    @Test
    public void testReduceFun5By3() {

        assertEquals(F5.apply(7, 11, 13, 17, 19),
                F5.apply(7, 11, 13).apply(17, 19));

    }

    @Test
    public void testReduceFun5By4() {

        assertEquals(F5.apply(7, 11, 13, 17, 19), F5.apply(7, 11, 13, 17)
                .apply(19));

    }

}
