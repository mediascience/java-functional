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

import com.msiops.footing.functional.FunT1;
import com.msiops.footing.functional.FunT2;
import com.msiops.footing.functional.FunT3;
import com.msiops.footing.functional.FunT4;
import com.msiops.footing.functional.FunT5;

public class FunTTest {

    private static final FunT1<Integer, Integer> F1 = t1 -> t1 * 211;

    private static final FunT2<Integer, Integer, Integer> F2 = (t1, t2) -> t1
            * 211 + t2 * 223;

    private static final FunT3<Integer, Integer, Integer, Integer> F3 = (t1,
            t2, t3) -> t1 * 211 + t2 * 223 + t3 * 227;

    private static final FunT4<Integer, Integer, Integer, Integer, Integer> F4 = (
            t1, t2, t3, t4) -> t1 * 211 + t2 * 223 + t3 * 227 + t4 * 229;

    private static final FunT5<Integer, Integer, Integer, Integer, Integer, Integer> F5 = (
            t1, t2, t3, t4, t5) -> t1 * 211 + t2 * 223 + t3 * 227 + t4 * 229
            + t5 * 233;

    private static final FunT1<Integer, Integer> FX1;

    private static final FunT2<Integer, Integer, Integer> FX2;

    private static final FunT3<Integer, Integer, Integer, Integer> FX3;
    private static final FunT4<Integer, Integer, Integer, Integer, Integer> FX4;

    private static final FunT5<Integer, Integer, Integer, Integer, Integer, Integer> FX5;

    private static final Exception X = new Exception();

    static {
        FX1 = t1 -> {
            throw X;
        };

        FX2 = (t1, t2) -> {
            throw X;
        };

        FX3 = (t1, t2, t3) -> {
            throw X;
        };

        FX4 = (t1, t2, t3, t4) -> {
            throw X;
        };

        FX5 = (t1, t2, t3, t4, t5) -> {
            throw X;
        };
    }

    @Test
    public void testFunT1() throws Throwable {

        assertEquals(7 * 211, F1.apply(7).intValue());

    }

    @Test
    public void testFunT1Throws() {

        try {
            FX1.apply(1);
            fail("should throw");
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testFunT2() throws Throwable {

        assertEquals(7 * 211 + 11 * 223, F2.apply(7, 11).intValue());

    }

    @Test
    public void testFunT2Throws() {

        try {
            FX2.apply(1, 2);
            fail("should throw");
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testFunT3() throws Throwable {

        assertEquals(7 * 211 + 11 * 223 + 13 * 227, F3.apply(7, 11, 13)
                .intValue());

    }

    @Test
    public void testFunT3Throws() {

        try {
            FX3.apply(1, 2, 3);
            fail("should throw");
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testFunT4() throws Throwable {

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229,
                F4.apply(7, 11, 13, 17).intValue());

    }

    @Test
    public void testFunT4Throws() {

        try {
            FX4.apply(1, 2, 3, 4);
            fail("should throw");
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testFunT5() throws Throwable {

        assertEquals(7 * 211 + 11 * 223 + 13 * 227 + 17 * 229 + 19 * 233, F5
                .apply(7, 11, 13, 17, 19).intValue());
    }

    @Test
    public void testFunT5Throws() {

        try {
            FX5.apply(1, 2, 3, 4, 5);
            fail("should throw");
        } catch (final Throwable x) {
            assertEquals(X, x);
        }

    }

    @Test
    public void testReduceFunT2By1() throws Throwable {

        assertEquals(F2.apply(7, 11), F2.apply(7).apply(11));

    }

    @Test
    public void testReduceFunT3By1() throws Throwable {

        assertEquals(F3.apply(7, 11, 13), F3.apply(7).apply(11, 13));

    }

    @Test
    public void testReduceFunT3By2() throws Throwable {

        assertEquals(F3.apply(7, 11, 13), F3.apply(7, 11).apply(13));

    }

    @Test
    public void testReduceFunT4By1() throws Throwable {

        assertEquals(F4.apply(7, 11, 13, 17), F4.apply(7).apply(11, 13, 17));

    }

    @Test
    public void testReduceFunT4By2() throws Throwable {

        assertEquals(F4.apply(7, 11, 13, 17), F4.apply(7, 11).apply(13, 17));

    }

    @Test
    public void testReduceFunT4By3() throws Throwable {

        assertEquals(F4.apply(7, 11, 13, 17), F4.apply(7, 11, 13).apply(17));

    }

    @Test
    public void testReduceFunT5By1() throws Throwable {

        assertEquals(F5.apply(7, 11, 13, 17, 19),
                F5.apply(7).apply(11, 13, 17, 19));

    }

    @Test
    public void testReduceFunT5By2() throws Throwable {

        assertEquals(F5.apply(7, 11, 13, 17, 19),
                F5.apply(7, 11).apply(13, 17, 19));

    }

    @Test
    public void testReduceFunT5By3() throws Throwable {

        assertEquals(F5.apply(7, 11, 13, 17, 19),
                F5.apply(7, 11, 13).apply(17, 19));

    }

    @Test
    public void testReduceFunT5By4() throws Throwable {

        assertEquals(F5.apply(7, 11, 13, 17, 19), F5.apply(7, 11, 13, 17)
                .apply(19));

    }

}
