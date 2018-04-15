/*
 * This file is part of xml, licensed under the MIT License.
 *
 * Copyright (c) 2018 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.xml.node.stream;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

public interface NodeStreamElement<T> {
  NodeStreamElement<Object> EMPTY = Optional::empty;

  static <T> NodeStreamElement<T> empty() {
    return (NodeStreamElement) EMPTY;
  }

  /**
   * Gets an optional representing {@code T}.
   *
   * @return an optional
   */
  Optional<T> want();

  /**
   * Gets {@code T}.
   *
   * @return {@code T}
   */
  default T need() {
    return this.want().orElseThrow(NoSuchElementException::new);
  }

  /**
   * Returns a stream element consisting of the result of applying the given
   * function to {@code T}.
   *
   * @param mapper the function to apply to {@code T}
   * @param <R> the type of the new stream element
   * @return a new stream element
   */
  default <R> NodeStreamElement<R> map(final Function<? super T, ? extends R> mapper) {
    return () -> this.want().map(mapper);
  }
}
