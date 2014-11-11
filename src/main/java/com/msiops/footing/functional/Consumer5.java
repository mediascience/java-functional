/**
 * Licensed under the Apache License, Version 2.0 (the "License") under
 * one or more contributor license agreements. See the NOTICE file
 * distributed with this work for information regarding copyright
 * ownership. You may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.msiops.footing.functional;

import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Consumer5<T1, T2, T3, T4, T5> extends
        Function<T1, Consumer4<T2, T3, T4, T5>> {

    void accept(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5);

    @Override
    default Consumer4<T2, T3, T4, T5> apply(final T1 t1) {
        return (t2, t3, t4, t5) -> accept(t1, t2, t3, t4, t5);
    }

    default Consumer3<T3, T4, T5> apply(final T1 t1, final T2 t2) {
        return (t3, t4, t5) -> accept(t1, t2, t3, t4, t5);
    }

    default Consumer2<T4, T5> apply(final T1 t1, final T2 t2, final T3 t3) {
        return (t4, t5) -> accept(t1, t2, t3, t4, t5);
    }

    default Consumer<T5> apply(final T1 t1, final T2 t2, final T3 t3,
            final T4 t4) {
        return (t5) -> accept(t1, t2, t3, t4, t5);
    }

}
