/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lebao.common.dbhelp.dbutils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.lebao.common.dbhelp.dbutils.ResultSetHandler;
import com.lebao.common.dbhelp.dbutils.StringRowProcessor;

/**
 * <code>ResultSetHandler</code> implementation that converts the first
 * <code>ResultSet</code> row into a <code>Map</code>. This class is thread 
 * safe.
 * 
 * @see com.lebao.common.dbhelp.dbutils.ResultSetHandler
 */
public class StringMapHandler implements ResultSetHandler<Map<String, String>> {

    /**
     * The StringRowProcessor implementation to use when converting rows
     * into Maps.
     */
    private final StringRowProcessor convert;

    /** 
     * Creates a new instance of MapHandler using a 
     * <code>BasicStringRowProcessor</code> for conversion.
     */
    public StringMapHandler() {
        this(StringArrayHandler.ROW_PROCESSOR);
    }

    /** 
     * Creates a new instance of MapHandler.
     * 
     * @param convert The <code>StringRowProcessor</code> implementation
     * to use when converting rows into Maps.
     */
    public StringMapHandler(StringRowProcessor convert) {
        super();
        this.convert = convert;
    }

    /**
     * Converts the first row in the <code>ResultSet</code> into a 
     * <code>Map</code>.
     * 
     * @return A <code>Map</code> with the values from the first row or 
     * <code>null</code> if there are no rows in the <code>ResultSet</code>. 
     * 
     * @throws java.sql.SQLException if a database access error occurs
     * 
     * @see com.lebao.common.dbhelp.dbutils.ResultSetHandler#handle(java.sql.ResultSet)
     */
    public Map<String, String> handle(ResultSet rs) throws SQLException {
        return rs.next() ? this.convert.toMap(rs) : null;
    }

}
