/*
 * ao-appcluster-dnsonly - Application-level clustering tools to monitor DNS for component states.
 * Copyright (C) 2011, 2015, 2016, 2019, 2020, 2021, 2022, 2023, 2024  AO Industries, Inc.
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

import com.aoapps.appcluster.AppCluster;
import com.aoapps.appcluster.AppClusterConfigurationException;
import com.aoapps.appcluster.AppClusterPropertiesConfiguration;
import com.aoapps.appcluster.ResourceNode;
import com.aoapps.appcluster.ResourcePropertiesConfiguration;
import com.aoapps.collections.AoCollections;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collection;
import java.util.Set;

/**
 * The configuration for a DNS-only resource.
 *
 * @author  AO Industries, Inc.
 */
public class DnsOnlyResourcePropertiesConfiguration extends ResourcePropertiesConfiguration<DnsOnlyResource, DnsOnlyResourceNode> implements DnsOnlyResourceConfiguration {

  private final boolean allowMultiMaster;

  /**
   * Creates a new {@link DnsOnlyResourcePropertiesConfiguration}.
   */
  @SuppressFBWarnings("CT_CONSTRUCTOR_THROW")
  protected DnsOnlyResourcePropertiesConfiguration(AppClusterPropertiesConfiguration properties, String id) throws AppClusterConfigurationException {
    super(properties, id);
    this.allowMultiMaster = properties.getBoolean("appcluster.resource." + id + "." + type + ".allowMultiMaster");
  }

  @Override
  public boolean getAllowMultiMaster() {
    return allowMultiMaster;
  }

  @Override
  public Set<? extends DnsOnlyResourceNodePropertiesConfiguration> getResourceNodeConfigurations() throws AppClusterConfigurationException {
    String resourceId = getId();
    Set<String> nodeIds = properties.getUniqueStrings("appcluster.resource." + id + ".nodes", true);
    Set<DnsOnlyResourceNodePropertiesConfiguration> resourceNodes = AoCollections.newLinkedHashSet(nodeIds.size());
    for (String nodeId : nodeIds) {
      if (!resourceNodes.add(new DnsOnlyResourceNodePropertiesConfiguration(properties, resourceId, nodeId, type))) {
        throw new AssertionError();
      }
    }
    return AoCollections.optimalUnmodifiableSet(resourceNodes);
  }

  @Override
  public DnsOnlyResource newResource(AppCluster cluster, Collection<? extends ResourceNode<?, ?>> resourceNodes) throws AppClusterConfigurationException {
    return new DnsOnlyResource(cluster, this, resourceNodes);
  }
}
