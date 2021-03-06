/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gobblin.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gobblin.codec.StreamCodec;


/**
 * Codec class that supports GPG decryption (only).
 */
public class GPGCodec implements StreamCodec {
  public static final String TAG = "gpg";

  private final String password;

  public GPGCodec(String password) {
    this.password = password;
  }

  @Override
  public OutputStream encodeOutputStream(OutputStream origStream)
      throws IOException {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  @Override
  public InputStream decodeInputStream(InputStream origStream)
      throws IOException {
    return GPGFileDecryptor.decryptFile(origStream, password);
  }

  @Override
  public String getTag() {
    return TAG;
  }
}
