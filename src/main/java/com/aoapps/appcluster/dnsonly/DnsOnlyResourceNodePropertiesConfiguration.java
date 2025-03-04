/*
 * ao-appcluster-dnsonly - Application-level clustering tools to monitor DNS for component states.
 * Copyright (C) 2011, 2016, 2021, 2022, 2023, 2024, 2025  AO Industries, Inc.
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

package com.aoapps.appcluster.dnsonly;

import com.aoapps.appcluster.AppClusterConfigurationException;
import com.aoapps.appcluster.AppClusterPropertiesConfiguration;
import com.aoapps.appcluster.Node;
import com.aoapps.appcluster.ResourceNodePropertiesConfiguration;

/**
 * The configuration for a DNS-only resource.
 *
 * @author  AO Industries, Inc.
 */
public class DnsOnlyResourceNodePropertiesConfiguration extends ResourceNodePropertiesConfiguration<DnsOnlyResource, DnsOnlyResourceNode> implements DnsOnlyResourceNodeConfiguration {

  /**
   * Creates a new {@link DnsOnlyResourceNodePropertiesConfiguration}.
   */
  protected DnsOnlyResourceNodePropertiesConfiguration(AppClusterPropertiesConfiguration properties, String resourceId, String nodeId, String type) throws AppClusterConfigurationException {
    super(properties, resourceId, nodeId);
  }

  @Override
  public DnsOnlyResourceNode newResourceNode(Node node) throws AppClusterConfigurationException {
    return new DnsOnlyResourceNode(node, this);
  }
}
