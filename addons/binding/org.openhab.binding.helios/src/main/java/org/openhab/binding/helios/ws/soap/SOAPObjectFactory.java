/**
 * Copyright (c) 2014 openHAB UG (haftungsbeschraenkt) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.helios.ws.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.openhab.binding.helios.handler.HeliosHandler27;

/**
 * The {@link SOAPObjectFactory} is a helper class that is used to generate JAXB
 * Elements
 * 
 * @author Karel Goderis - Initial contribution
 */
@XmlRegistry
public class SOAPObjectFactory {

	private final static QName _Data_QNAME = new QName(
			HeliosHandler27.HELIOS_URI, "Data");

	@XmlElementDecl(namespace = HeliosHandler27.HELIOS_URI, name = "CallStateChanged")
	public JAXBElement<SOAPCallStateChanged> createHeliosCallStateChanged(
			SOAPCallStateChanged value) {
		return new JAXBElement<SOAPCallStateChanged>(_Data_QNAME,
				SOAPCallStateChanged.class, null, value);
	}

	@XmlElementDecl(namespace = HeliosHandler27.HELIOS_URI, name = "CodeEntered")
	public JAXBElement<SOAPCodeEntered> createHeliosCodeEntered(
			SOAPCodeEntered value) {
		return new JAXBElement<SOAPCodeEntered>(_Data_QNAME,
				SOAPCodeEntered.class, null, value);
	}

	@XmlElementDecl(namespace = HeliosHandler27.HELIOS_URI, name = "CardEntered")
	public JAXBElement<SOAPCardEntered> createHeliosCardEntered(
			SOAPCardEntered value) {
		return new JAXBElement<SOAPCardEntered>(_Data_QNAME,
				SOAPCardEntered.class, null, value);
	}

	@XmlElementDecl(namespace = HeliosHandler27.HELIOS_URI, name = "DeviceState")
	public JAXBElement<SOAPDeviceState> createHeliosDeviceState(
			SOAPDeviceState value) {
		return new JAXBElement<SOAPDeviceState>(_Data_QNAME,
				SOAPDeviceState.class, null, value);
	}

	@XmlElementDecl(namespace = HeliosHandler27.HELIOS_URI, name = "KeyPressed")
	public JAXBElement<SOAPKeyPressed> createHeliosKeyPressedd(
			SOAPKeyPressed value) {
		return new JAXBElement<SOAPKeyPressed>(_Data_QNAME,
				SOAPKeyPressed.class, null, value);
	}

}
