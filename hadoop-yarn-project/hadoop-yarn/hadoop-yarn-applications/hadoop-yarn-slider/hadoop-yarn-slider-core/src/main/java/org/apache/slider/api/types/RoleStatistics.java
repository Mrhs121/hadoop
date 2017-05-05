/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.slider.api.types;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Simple role statistics for state views; can be generated by RoleStatus
 * instances, and aggregated for summary information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleStatistics {
  public long activeAA  = 0L;
  public long actual = 0L;
  public long completed = 0L;
  public long desired = 0L;
  public long failed = 0L;
  public long failedRecently = 0L;
  public long limitsExceeded = 0L;
  public long nodeFailed = 0L;
  public long preempted = 0L;
  public long requested = 0L;
  public long started = 0L;

  /**
   * Add another statistics instance
   * @param that the other value
   * @return this entry
   */
  public RoleStatistics add(final RoleStatistics that) {
    activeAA += that.activeAA;
    actual += that.actual;
    completed += that.completed;
    desired += that.desired;
    failed += that.failed;
    failedRecently += that.failedRecently;
    limitsExceeded += that.limitsExceeded;
    nodeFailed += that.nodeFailed;
    preempted += that.preempted;
    requested += that.requested;
    started += that.started;
    return this;
  }
}