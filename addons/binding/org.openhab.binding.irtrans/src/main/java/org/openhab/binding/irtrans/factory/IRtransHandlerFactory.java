/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.irtrans.factory;

import java.util.Collection;

import org.eclipse.smarthome.config.core.Configuration;
import org.eclipse.smarthome.core.thing.Bridge;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingTypeUID;
import org.eclipse.smarthome.core.thing.ThingUID;
import org.eclipse.smarthome.core.thing.binding.BaseThingHandlerFactory;
import org.eclipse.smarthome.core.thing.binding.ThingHandler;
import org.openhab.binding.irtrans.IRtransBindingConstants;
import org.openhab.binding.irtrans.handler.BlasterHandler;
import org.openhab.binding.irtrans.handler.EthernetBridgeHandler;

import com.google.common.collect.Lists;

/**
 * The {@link IRtransHandlerFactory} is responsible for creating things and
 * thing handlers.
 *
 * @author Karel Goderis - Initial contribution
 * @since 2.1.0
 *
 */
public class IRtransHandlerFactory extends BaseThingHandlerFactory {

    public final static Collection<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Lists.newArrayList(
            IRtransBindingConstants.THING_TYPE_BLASTER, IRtransBindingConstants.THING_TYPE_ETHERNET_BRIDGE);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    @Override
    public Thing createThing(ThingTypeUID thingTypeUID, Configuration configuration, ThingUID thingUID,
            ThingUID bridgeUID) {
        if (IRtransBindingConstants.THING_TYPE_ETHERNET_BRIDGE.equals(thingTypeUID)) {
            ThingUID ethernetBridgeUID = getEthernetBridgeThingUID(thingTypeUID, thingUID, configuration);
            return super.createThing(thingTypeUID, configuration, ethernetBridgeUID, null);
        }
        if (IRtransBindingConstants.THING_TYPE_BLASTER.equals(thingTypeUID)) {
            ThingUID blasterUID = getBlasterUID(thingTypeUID, thingUID, configuration, bridgeUID);
            return super.createThing(thingTypeUID, configuration, blasterUID, bridgeUID);
        }
        throw new IllegalArgumentException(
                "The thing type " + thingTypeUID + " is not supported by the IRtrans binding.");
    }

    @Override
    protected ThingHandler createHandler(Thing thing) {
        if (thing.getThingTypeUID().equals(IRtransBindingConstants.THING_TYPE_ETHERNET_BRIDGE)) {
            return new EthernetBridgeHandler((Bridge) thing);
        } else if (thing.getThingTypeUID().equals(IRtransBindingConstants.THING_TYPE_BLASTER)) {
            return new BlasterHandler(thing);
        } else {
            return null;
        }
    }

    private ThingUID getEthernetBridgeThingUID(ThingTypeUID thingTypeUID, ThingUID thingUID,
            Configuration configuration) {
        if (thingUID == null) {
            String ipAddress = (String) configuration.get(EthernetBridgeHandler.IP_ADDRESS);
            thingUID = new ThingUID(thingTypeUID, ipAddress);
        }
        return thingUID;
    }

    private ThingUID getBlasterUID(ThingTypeUID thingTypeUID, ThingUID thingUID, Configuration configuration,
            ThingUID bridgeUID) {
        String ledId = (String) configuration.get(BlasterHandler.LED);

        if (thingUID == null) {
            thingUID = new ThingUID(thingTypeUID, "Led" + ledId, bridgeUID.getId());
        }
        return thingUID;
    }
}
