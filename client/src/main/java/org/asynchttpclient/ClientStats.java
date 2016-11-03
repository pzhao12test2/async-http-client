/*
 * Copyright (c) 2014 AsyncHttpClient Project. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at
 *     http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package org.asynchttpclient;

import java.util.Objects;

/**
 * A record class representing the state of an (@link org.asynchttpclient.AsyncHttpClient)
 */
public class ClientStats {

    private final long activeConnectionCount;
    private final long idleConnectionCount;

    public ClientStats(long activeConnectionCount,
                       long idleConnectionCount) {
        this.activeConnectionCount = activeConnectionCount;
        this.idleConnectionCount = idleConnectionCount;
    }

    /**
     * @return The sum of {@link #getActiveConnectionCount()} and {@link #getIdleConnectionCount()},
     * a long representing the total number of connections in the connection pool.
     */
    public long getTotalConnectionCount() {
        return activeConnectionCount + idleConnectionCount;
    }

    /**
     * @return A long representing the number of active connection in the connection pool.
     */
    public long getActiveConnectionCount() {
        return activeConnectionCount;
    }

    /**
     *
     * @return A long representing the number of idle connections in the connection pool.
     */
    public long getIdleConnectionCount() {
        return idleConnectionCount;
    }

    @Override
    public String toString() {
        return "There are " + getTotalConnectionCount() +
                " total connections, " + getActiveConnectionCount() +
                " are active and " + getIdleConnectionCount() + " are idle.";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ClientStats that = (ClientStats) o;
        return activeConnectionCount == that.activeConnectionCount &&
                idleConnectionCount == that.idleConnectionCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(activeConnectionCount, idleConnectionCount);
    }
}
