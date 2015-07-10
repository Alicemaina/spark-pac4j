/*
  Copyright 2015 - 2015 pac4j organization

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.pac4j.sparkjava;

import org.pac4j.core.exception.RequiresHttpAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.halt;

/**
 * Default behaviour to handle {@link RequiresHttpAction}.
 *
 * @author Jerome Leleu
 * @since 1.0.0
 */
public abstract class ExtraHttpActionHandler {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected void handle(final SparkWebContext context, final RequiresHttpAction e) {
        int status = e.getCode();
        logger.debug("extra HTTP action required : {}", status);
        if (status == 200) {
            halt(200, context.getBody());
        } else {
            halt(status, e.getMessage());
        }
    }
}
