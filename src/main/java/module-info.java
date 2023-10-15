/*
 * ao-appcluster-dnsonly - Application-level clustering tools to monitor DNS for component states.
 * Copyright (C) 2021, 2022, 2023  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of ao-appcluster-dnsonly.
 *
 * ao-appcluster-dnsonly is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ao-appcluster-dnsonly is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ao-appcluster-dnsonly.  If not, see <https://www.gnu.org/licenses/>.
 */
module com.aoapps.appcluster.dnsonly {
  exports com.aoapps.appcluster.dnsonly;
  // Direct
  requires com.aoapps.appcluster.core; // <groupId>com.aoapps</groupId><artifactId>ao-appcluster-core</artifactId>
  requires com.aoapps.collections; // <groupId>com.aoapps</groupId><artifactId>ao-collections</artifactId>
  requires static com.github.spotbugs.annotations; // <groupId>com.github.spotbugs</groupId><artifactId>spotbugs-annotations</artifactId>
}
