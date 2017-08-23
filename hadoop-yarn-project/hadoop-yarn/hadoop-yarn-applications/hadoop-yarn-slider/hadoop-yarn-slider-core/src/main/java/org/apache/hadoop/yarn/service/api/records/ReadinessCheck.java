/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.service.api.records;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;

/**
 * A custom command or a pluggable helper container to determine the readiness
 * of a container of a component. Readiness for every application is different.
 * Hence the need for a simple interface, with scope to support advanced
 * usecases.
 **/
@InterfaceAudience.Public
@InterfaceStability.Unstable
@ApiModel(description = "A custom command or a pluggable helper container to determine the readiness of a container of a component. Readiness for every application is different. Hence the need for a simple interface, with scope to support advanced usecases.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-06-02T08:15:05.615-07:00")
public class ReadinessCheck implements Serializable {
  private static final long serialVersionUID = -3836839816887186801L;

  public enum TypeEnum {
    HTTP("HTTP"),
    PORT("PORT");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return value;
    }
  }

  private TypeEnum type = null;
  private Map<String, String> props = new HashMap<String, String>();
  private Artifact artifact = null;

  /**
   * E.g. HTTP (YARN will perform a simple REST call at a regular interval and
   * expect a 204 No content).
   **/
  public ReadinessCheck type(TypeEnum type) {
    this.type = type;
    return this;
  }

  @ApiModelProperty(example = "null", value = "E.g. HTTP (YARN will perform a simple REST call at a regular interval and expect a 204 No content).")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ReadinessCheck props(Map<String, String> props) {
    this.props = props;
    return this;
  }

  public ReadinessCheck putPropsItem(String key, String propsItem) {
    this.props.put(key, propsItem);
    return this;
  }

  /**
   * A blob of key value pairs that will be used to configure the check.
   * @return props
   **/
  @ApiModelProperty(example = "null", value = "A blob of key value pairs that will be used to configure the check.")
  public Map<String, String> getProps() {
    return props;
  }

  public void setProps(Map<String, String> props) {
    this.props = props;
  }

  /**
   * Artifact of the pluggable readiness check helper container (optional). If
   * specified, this helper container typically hosts the http uri and
   * encapsulates the complex scripts required to perform actual container
   * readiness check. At the end it is expected to respond a 204 No content just
   * like the simplified use case. This pluggable framework benefits application
   * owners who can run applications without any packaging modifications. Note,
   * artifacts of type docker only is supported for now.
   **/
  public ReadinessCheck artifact(Artifact artifact) {
    this.artifact = artifact;
    return this;
  }

  @ApiModelProperty(example = "null", value = "Artifact of the pluggable readiness check helper container (optional). If specified, this helper container typically hosts the http uri and encapsulates the complex scripts required to perform actual container readiness check. At the end it is expected to respond a 204 No content just like the simplified use case. This pluggable framework benefits application owners who can run applications without any packaging modifications. Note, artifacts of type docker only is supported for now.")
  @JsonProperty("artifact")
  public Artifact getArtifact() {
    return artifact;
  }

  public void setArtifact(Artifact artifact) {
    this.artifact = artifact;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReadinessCheck readinessCheck = (ReadinessCheck) o;
    return Objects.equals(this.type, readinessCheck.type) &&
        Objects.equals(this.props, readinessCheck.props) &&
        Objects.equals(this.artifact, readinessCheck.artifact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, props, artifact);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReadinessCheck {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    props: ").append(toIndentedString(props)).append("\n");
    sb.append("    artifact: ").append(toIndentedString(artifact)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}