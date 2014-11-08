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

import com.msiops.footing.functional.ConsumerX1;
import com.msiops.footing.functional.ConsumerX2;
import com.msiops.footing.functional.ConsumerX3;
import com.msiops.footing.functional.ConsumerX4;
import com.msiops.footing.functional.ConsumerX5;

public class ConsumerXTest {

    private static final Exception X = new RuntimeException("ouch");

    private final ConsumerX1<Integer, Exception> c1 = (t1) -> {
        this.result = t1 * 211;
    };

    private final ConsumerX2<Integer, Integer, Exception> c2 = (t1, t2) -> {
        this.result = t1 * 211 + t2 * 223;
    };

    private final ConsumerX3<Integer, Integer, Integer, Exception> c3 = (t1,
            t2, t3) -> {
        this.result = t1 * 211 + t2 * 223 + t3 * 227;
    };

    private final ConsumerX4<Integer, Integer, Integer, Integer, Exception> c4 = (
            t1, t2, t3, t4) -> {
        this.result = t1 * 211 + t2 * 223 + t3 * 227 + t4 * 229;
    };

    private final ConsumerX5<Integer, Integer, Integer, Integer, Integer, Exception> c5 = (
            t1, t2, t3, t4, t5) -> {
        this.result = t1 * 211 + t2 * 223 + t3 * 227 + t4 * 229 + t5 * 233;
    };

    private final ConsumerX1<Integer, Exception> cx1 = (t1) -> {
        throw X;
    };

    private final ConsumerX2<Integer, Integer, Exception> cx2 = (t1, t2) -> {
        throw X;
    };

    private final ConsumerX3<Integer, Integer, Integer, Exception> cx3 = (t1,
            t2, t3) -> {
        throw X;
    };

    private final ConsumerX4<Integer, Integer, Integer, Integer, Exception> cx4 = (
            t1, t2, t3, t4) -> {
        throw X;
    };

    private final ConsumerX5<Integer, Integer, Integer, Integer, Integer, Exception> cx5 = (
            t1, t2, t3, t4, t5) -> {
        throw X;
    };

    private int result;

    @Before
    public void setup() {

        this.result = 0;

    }

    @Test
    public void testConsumerX1() throws Throwable {

        this.c1.accept(7);

        assertEquals(7 * 211, this.result);

    }

    @Test
    public void testConsumerX1Throws() {

        try {
            this.cx1.accept(7);
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testConsumerX2() throws Throwable {

        this.c2.accept(7, 11);

        assertEquals(7 * 211 + 11 * 223, this.result);

    }

    @Test
    public void testConsumerX2Throws() {

        try {
            this.cx2.accept(7, 11);
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testConsumerX3() throws Throwable {

        this.c3.accept(7, 11, 13);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, this.result);

    }

    @Test
    public void testConsumerX3Throws() {

        try {
            this.cx3.accept(7, 11, 13);
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testConsumerX4() throws Throwable {

        this.c4.accept(7, 11, 13, 17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testConsumerX4Throws() {

        try {
            this.cx4.accept(7, 11, 13, 17);
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testConsumerX5() throws Throwable {

        this.c5.accept(7, 11, 13, 17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);
    }

    @Test
    public void testConsumerX5Throws() {

        try {
            this.cx5.accept(7, 11, 13, 17, 19);
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testReduceConsumerX2By1() throws Throwable {

        this.c2.apply(7).accept(11);

        assertEquals(7 * 211 + 11 * 223, this.result);

    }

    @Test
    public void testReduceConsumerX3By1() throws Throwable {

        this.c3.apply(7).accept(11, 13);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, this.result);

    }

    @Test
    public void testReduceConsumerX3By2() throws Throwable {

        this.c3.apply(7, 11).accept(13);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, this.result);

    }

    @Test
    public void testReduceConsumerX4By1() throws Throwable {

        this.c4.apply(7).accept(11, 13, 17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testReduceConsumerX4By2() throws Throwable {

        this.c4.apply(7, 11).accept(13, 17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testReduceConsumerX4By3() throws Throwable {

        this.c4.apply(7, 11, 13).accept(17);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229, this.result);

    }

    @Test
    public void testReduceConsumerX5By1() throws Throwable {

        this.c5.apply(7).accept(11, 13, 17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

    @Test
    public void testReduceConsumerX5By2() throws Throwable {

        this.c5.apply(7, 11).accept(13, 17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

    @Test
    public void testReduceConsumerX5By3() throws Throwable {

        this.c5.apply(7, 11, 13).accept(17, 19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

    @Test
    public void testReduceConsumerX5By4() throws Throwable {

        this.c5.apply(7, 11, 13, 17).accept(19);

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233,
                this.result);

    }

}
