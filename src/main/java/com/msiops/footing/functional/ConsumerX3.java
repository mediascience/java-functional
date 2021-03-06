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

import java.util.function.Function;

@FunctionalInterface
public interface ConsumerX3<T1, T2, T3, X extends Throwable> extends
        Function<T1, ConsumerX2<T2, T3, X>> {

    void accept(T1 t1, T2 t2, T3 t3) throws X;

    @Override
    default ConsumerX2<T2, T3, X> apply(final T1 t1) {
        return (t2, t3) -> accept(t1, t2, t3);
    }

    default ConsumerX1<T3, X> apply(final T1 t1, final T2 t2) {
        return (t3) -> accept(t1, t2, t3);
    }

}
