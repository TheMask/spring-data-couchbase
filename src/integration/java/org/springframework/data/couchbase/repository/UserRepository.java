/*
 * Copyright 2013 the original author or authors.
 *
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
 */

package org.springframework.data.couchbase.repository;

import com.couchbase.client.java.view.ViewQuery;

import org.springframework.data.couchbase.core.view.N1QL;
import org.springframework.data.couchbase.core.view.View;

/**
 * @author Michael Nitschinger
 */
public interface UserRepository extends CouchbaseRepository<User, String> {

  @View(designDocument = "user", viewName = "all")
  Iterable<User> customViewQuery(ViewQuery query);

  @N1QL("$SELECT_ENTITY$ WHERE username = $1")
  User findByUsername(String username);

  @N1QL("SELECT * FROM $BUCKET$ WHERE username = $1")
  User findByUsernameBadSelect(String username);

}
