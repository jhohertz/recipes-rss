/*
 * Copyright 2012 Netflix, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.netflix.recipes.rss.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.karyon.spi.PropertyNames;

/**
 * @author Chris Fregly (chris@fregly.com)
 */
public class MiddleTierServer extends BaseNettyServer {
	private static final Logger logger = LoggerFactory.getLogger(MiddleTierServer.class);
	private static MiddleTierServer middleTierServer = new MiddleTierServer();
	
	public MiddleTierServer() {
        }
    
        public static void main(String args[]) throws Exception {
       	        middleTierServer.initialize();
       	        middleTierServer.start();
        }
    
	private void initialize() {
    	        System.setProperty("archaius.deployment.applicationId", "middletier");
    	        System.setProperty(PropertyNames.SERVER_BOOTSTRAP_BASE_PACKAGES_OVERRIDE, "com.netflix");
	}
	
	// commons daemon methods:
        public void init(String[] arguments) throws Exception {
                logger.debug("Daemon init");
                middleTierServer.initialize();
        }

        public void start() {
                logger.debug("Daemon start");
                super.start();
        }

        public void stop() {
                logger.debug("Daemon stop");
                super.close();
        }

        public void destroy() {
                logger.debug("Daemon destroy");
        }
	
}
