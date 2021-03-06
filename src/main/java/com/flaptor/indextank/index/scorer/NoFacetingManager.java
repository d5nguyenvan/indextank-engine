/*
 * Copyright (c) 2011 LinkedIn, Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flaptor.indextank.index.scorer;

import java.util.Map;

import com.flaptor.indextank.index.DocId;
import com.flaptor.indextank.query.QueryVariables;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class NoFacetingManager extends FacetingManager {

	@Override
	public Faceter createFaceter() {
		return new Faceter() {
			@Override
			public Map<String, Multiset<String>> getFacets() {
				return ImmutableMap.of();
			}
			@Override
			public void computeDocument(DocId documentId) {
			}
		};
	}

	@Override
	public MatchFilter getFacetFilter(Multimap<String, String> facets) {
		return new MatchFilter() {
			@Override
			public boolean matches(DocId documentId, double textualScore, int now, QueryVariables queryVars) {
				return true;
			}
		};
	}

}
