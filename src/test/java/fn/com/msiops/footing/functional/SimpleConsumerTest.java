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

import org.junit.Before;
import org.junit.Test;

import com.msiops.footing.functional.Consumer2;
import com.msiops.footing.functional.Consumer3;
import com.msiops.footing.functional.Consumer4;
import com.msiops.footing.functional.Consumer5;

public class SimpleConsumerTest {

    private final Consumer2<Integer, Integer> c2 = (t1, t2) -> {
        this.result = t1 * 211 + t2 * 223;
    };

    private final Consumer3<Integer, Integer, Integer> c3 = (t1, t2, t3) -> {
        this.result = t1 * 211 + t2 * 223 + t3 * 227;
    };

    private final Consumer4<Integer, Integer, Integer, Integer> c4 = (t1, t2,
            t3, t4) -> {
        this.result = t1 * 211 + t2 * 223 + t3 * 227 + t4 * 229;
    };

    private final Consumer5<Integer, Integer, Integer, Integer, Integer> c5 = (
            t1, t2, t3, t4, t5) -> {
        this.result = t1 * 211 + t2 * 223 + t3 * 227 + t4 * 229 + t5 * 233;
    };

    private int result;

    @Before
    public void setup() {

        this.result = 0;

    }

    @Test
    public void testConsumer2() {

        this.c2.accept(7, 11);

        assertEquals(7 * 211 + 11 * 223, this.result);

    }

    @Test
    public void testConsumer3() {

        this.c3.accept(7, 11, 13);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, this.result);

    }

    @Test
    public void testConsumer4() {

        this.c4.accept(7, 11, 13, 17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testConsumer5() {

        this.c5.accept(7, 11, 13, 17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);
    }

    @Test
    public void testReduceConsumer2By1() {

        this.c2.apply(7).accept(11);

        assertEquals(7 * 211 + 11 * 223, this.result);

    }

    @Test
    public void testReduceConsumer3By1() {

        this.c3.apply(7).accept(11, 13);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, this.result);

    }

    @Test
    public void testReduceConsumer3By2() {

        this.c3.apply(7, 11).accept(13);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, this.result);

    }

    @Test
    public void testReduceConsumer4By1() {

        this.c4.apply(7).accept(11, 13, 17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testReduceConsumer4By2() {

        this.c4.apply(7, 11).accept(13, 17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testReduceConsumer4By3() {

        this.c4.apply(7, 11, 13).accept(17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testReduceConsumer5By1() {

        this.c5.apply(7).accept(11, 13, 17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

    @Test
    public void testReduceConsumer5By2() {

        this.c5.apply(7, 11).accept(13, 17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

    @Test
    public void testReduceConsumer5By3() {

        this.c5.apply(7, 11, 13).accept(17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

    @Test
    public void testReduceConsumer5By4() {

        this.c5.apply(7, 11, 13, 17).accept(19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

}
