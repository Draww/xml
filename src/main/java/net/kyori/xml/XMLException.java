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
package net.kyori.xml;

import net.kyori.xml.node.Node;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An exception involving XML.
 */
public class XMLException extends Exception {
  private final @Nullable Node node;

  public XMLException(final String message) {
    this(null, message);
  }

  public XMLException(final @Nullable Node node, final String message) {
    super(message);
    this.node = node;
  }

  public XMLException(final String message, final @Nullable Throwable cause) {
    this(null, message, cause);
  }

  public XMLException(final @Nullable Node node, final String message, final @Nullable Throwable cause) {
    super(message, cause);
    this.node = node;
  }

  public @Nullable Node node() {
    return this.node;
  }
}
