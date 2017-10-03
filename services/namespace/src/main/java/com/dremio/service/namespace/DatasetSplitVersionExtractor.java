/*
 * Copyright (C) 2017 Dremio Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dremio.service.namespace;

import com.dremio.datastore.VersionExtractor;
import com.dremio.service.namespace.dataset.proto.DatasetSplit;

/**
 * Dataset split versione extractor.
 */
class DatasetSplitVersionExtractor implements VersionExtractor<DatasetSplit> {
  @Override
  public Long getVersion(DatasetSplit value) {
    return value.getVersion();
  }

  @Override
  public Long incrementVersion(DatasetSplit value) {
    Long version = getVersion(value);
    setVersion(value, Long.valueOf((version == null) ? 0L : version.longValue() + 1L));
    return version;
  }

  @Override
  public void setVersion(DatasetSplit value, Long version) {
    value.setVersion(version);
  }
}