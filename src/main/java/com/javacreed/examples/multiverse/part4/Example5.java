/*
 * #%L
 * Software Transactional Memory Example using Multiverse
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.multiverse.part4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

import com.javacreed.examples.multiverse.utils.LoggerUtils;

public class Example5 {

  private static final Logger LOGGER = LoggerUtils.getLogger(Example5.class);

  public static void main(final String[] args) {
    final Account a = new Account(10);
    final Date date = new Date();
    a.adjustBy(-5, date);
    Example5.LOGGER.debug("Account {}", a);

    // Date is modified outside the transaction
    date.setTime(System.currentTimeMillis() - TimeUnit.HOURS.toMillis(1));
    Example5.LOGGER.debug("Account {}", a);
  }
}
