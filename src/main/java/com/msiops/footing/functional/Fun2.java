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
public interface Fun2<T1, T2, R> extends Function<T1, Function<T2, R>> {

    @Override
    default Function<T2, R> apply(final T1 t1) {
        return t2 -> apply(t1, t2);
    }

    R apply(T1 t1, T2 t2);

}
