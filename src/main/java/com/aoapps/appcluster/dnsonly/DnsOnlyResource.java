/*
 * ao-appcluster-dnsonly - Application-level clustering tools to monitor DNS for component states.
 * Copyright (C) 2011, 2016, 2021, 2022, 2023  AO Industries, Inc.
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
import com.aoapps.appcluster.Resource;
import com.aoapps.appcluster.ResourceConfiguration;
import com.aoapps.appcluster.ResourceNode;
import com.aoapps.appcluster.ResourceSynchronizer;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Collection;

/**
 * Synchronizes resources using DNS-only.
 *
 * @author  AO Industries, Inc.
 */
public class DnsOnlyResource extends Resource<DnsOnlyResource, DnsOnlyResourceNode> {

  //private final DnsOnlyResourceConfiguration resourceConfiguration;
  private final boolean allowMultiMaster;

  @SuppressFBWarnings("CT_CONSTRUCTOR_THROW")
  protected DnsOnlyResource(AppCluster cluster, DnsOnlyResourceConfiguration resourceConfiguration, Collection<? extends ResourceNode<?, ?>> resourceNodes) throws AppClusterConfigurationException {
    super(cluster, resourceConfiguration, resourceNodes);
    //this.resourceConfiguration = resourceConfiguration;
    this.allowMultiMaster = resourceConfiguration.getAllowMultiMaster();
  }

  @Override
  public boolean getAllowMultiMaster() {
    return allowMultiMaster;
  }

  @Override
  protected ResourceSynchronizer<DnsOnlyResource, DnsOnlyResourceNode> newResourceSynchronizer(
      DnsOnlyResourceNode localResourceNode,
      DnsOnlyResourceNode remoteResourceNode,
      ResourceConfiguration<DnsOnlyResource, DnsOnlyResourceNode> resourceConfiguration
  ) {
    return null;
  }
}
